package com.lms.service;

import java.util.NoSuchElementException;
import java.util.UUID;

import com.lms.exception.BookNotAvailableException;
import com.lms.exception.BookNotFoundException;
import com.lms.exception.MaxBorrowLimitException;
import com.lms.exception.MemberNotFoundException;
import com.lms.model.Book;
import com.lms.model.BookStatus;
import com.lms.model.Member;
import com.lms.repository.BookRepository;
import com.lms.repository.MemberRepository;

public class Library {

  private BookRepository bookRepo;
  private MemberRepository memberRepo;

  public Library(BookRepository bookRepo, MemberRepository memberRepo) {
    this.bookRepo = bookRepo;
    this.memberRepo = memberRepo;
  }

  public void borrowBook(UUID memberId, UUID bookId) {
    Book book = bookRepo.findById(bookId);
    Member member = memberRepo.findById(memberId);
    checkIfExists(book, member);
    if (book.getStatus() != BookStatus.AVAILABLE) {
      throw new BookNotAvailableException("Book is not available atp");
    }
    if (member.booksCount() >= 3) {
      throw new MaxBorrowLimitException("LIMIT EXCEEDED!!,member already has 3 books");
    }
    member.addBook(book);
    book.updateStatus(BookStatus.BORROWED);
  }

  public void returnBook(UUID memberId, UUID bookId) {
    Book book = bookRepo.findById(bookId);
    Member member = memberRepo.findById(memberId);
    checkIfExists(book, member);
    if (!member.hasBook(book))
      throw new NoSuchElementException("member never had the book");
    member.remove(book);
    book.updateStatus(BookStatus.AVAILABLE);
  }

  private void checkIfExists(Book book, Member member) {
    if (book == null)
      throw new BookNotFoundException();
    if (member == null)
      throw new MemberNotFoundException();
  }
}
