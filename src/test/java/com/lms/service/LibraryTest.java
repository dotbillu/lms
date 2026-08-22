package com.lms.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.lms.exception.BookNotAvailableException;
import com.lms.exception.BookNotFoundException;
import com.lms.exception.MaxBorrowLimitException;
import com.lms.exception.MemberNotFoundException;
import com.lms.model.Book;
import com.lms.model.BookStatus;
import com.lms.model.Member;
import com.lms.repository.BookRepository;
import com.lms.repository.MemberRepository;

public class LibraryTest {

  private Library library;
  private BookRepository bookRepo;
  private MemberRepository memberRepo;

  @BeforeEach
  public void setup() {
    bookRepo = new BookRepository();
    memberRepo = new MemberRepository();
    library = new Library(bookRepo, memberRepo);
  }

  @Test
  public void testAddAndListBooks() {
    Book book = new Book("Effective Java", "Joshua Bloch", "Programming");
    library.addBook(book);

    assertEquals(1, library.listBooks().size());
    assertEquals(book.getId(), library.listBooks().get(0).getId());
  }

  @Test
  public void testAddAndListMembers() {
    Member member = new Member("Alice", 25, "Female");
    library.addMember(member);

    assertEquals(1, library.listMembers().size());
    assertEquals(member.getId(), library.listMembers().get(0).getId());
  }

  @Test
  public void testBorrowBookSuccess() {
    Book book = new Book("Clean Code", "Robert C. Martin", "Programming");
    Member member = new Member("Bob", 30, "Male");

    library.addBook(book);
    library.addMember(member);

    library.borrowBook(member.getId(), book.getId());

    assertEquals(BookStatus.BORROWED, book.getStatus());
    assertTrue(member.hasBook(book));
    assertEquals(1, member.booksCount());
  }

  @Test
  public void testBorrowBookNotAvailable() {
    Book book = new Book("Clean Code", "Robert C. Martin", "Programming");
    Member member1 = new Member("Bob", 30, "Male");
    Member member2 = new Member("Charlie", 28, "Male");

    library.addBook(book);
    library.addMember(member1);
    library.addMember(member2);

    library.borrowBook(member1.getId(), book.getId());

    assertThrows(BookNotAvailableException.class, () -> {
      library.borrowBook(member2.getId(), book.getId());
    });
  }

  @Test
  public void testBorrowBookMaxLimit() {
    Member member = new Member("Dave", 22, "Male");
    library.addMember(member);

    Book b1 = new Book("B1", "A1", "G1");
    Book b2 = new Book("B2", "A2", "G2");
    Book b3 = new Book("B3", "A3", "G3");
    Book b4 = new Book("B4", "A4", "G4");

    library.addBook(b1);
    library.addBook(b2);
    library.addBook(b3);
    library.addBook(b4);

    library.borrowBook(member.getId(), b1.getId());
    library.borrowBook(member.getId(), b2.getId());
    library.borrowBook(member.getId(), b3.getId());

    assertThrows(MaxBorrowLimitException.class, () -> {
      library.borrowBook(member.getId(), b4.getId());
    });
  }

  @Test
  public void testReturnBookSuccess() {
    Book book = new Book("Design Patterns", "GoF", "Programming");
    Member member = new Member("Eve", 35, "Female");

    library.addBook(book);
    library.addMember(member);

    library.borrowBook(member.getId(), book.getId());
    library.returnBook(member.getId(), book.getId());

    assertEquals(BookStatus.AVAILABLE, book.getStatus());
    assertFalse(member.hasBook(book));
  }

  @Test
  public void testReturnBookNeverBorrowed() {
    Book book = new Book("Design Patterns", "GoF", "Programming");
    Member member = new Member("Eve", 35, "Female");

    library.addBook(book);
    library.addMember(member);

    assertThrows(NoSuchElementException.class, () -> {
      library.returnBook(member.getId(), book.getId());
    });
  }
}
