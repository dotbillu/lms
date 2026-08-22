package com.lms.cli;

import java.util.Scanner;
import java.util.UUID;

import com.lms.model.Book;
import com.lms.model.Member;
import com.lms.service.Library;

public class LibraryCLI {
  private Library library;
  private Scanner scanner = new Scanner(System.in);

  public LibraryCLI(Library library) {
    this.library = library;
  }

  public void start() {
    while (true) {
      System.out.println("""
          ===== Library Management System =====
          1. Add book
          2. Add member
          3. Borrow book
          4. Return book
          5. List books
          6. List members
          7. Exit

          Choose:
          """);

      int choice = scanner.nextInt();
      scanner.nextLine();
      try {
        switch (choice) {
          case 1 -> addBook();
          case 2 -> addMember();
          case 3 -> borrowBook();
          case 4 -> returnBook();
          case 5 -> listBooks();
          case 6 -> listMembers();
          case 7 -> {
            return;
          }
          default -> System.out.println("Invalid choice");
        }

      } catch (RuntimeException e) {
        System.out.println(e.getMessage());
      }
    }
  }

  private void addBook() {
    System.out.print("Title: ");
    String title = scanner.nextLine();

    System.out.print("Author: ");
    String author = scanner.nextLine();

    System.out.print("Genre: ");
    String genre = scanner.nextLine();

    Book book = new Book(title, author, genre);
    library.addBook(book);

    System.out.println("Book added.");
  }

  private void addMember() {
    System.out.print("Name: ");
    String name = scanner.nextLine();

    System.out.print("Age: ");
    int age = scanner.nextInt();
    scanner.nextLine();

    System.out.print("Gender: ");
    String gender = scanner.nextLine();

    Member member = new Member(name, age, gender);
    library.addMember(member);

    System.out.println("Member added.");
  }

  private void borrowBook() {
    System.out.print("Member ID: ");
    UUID memberId = UUID.fromString(scanner.nextLine());

    System.out.print("Book ID: ");
    UUID bookId = UUID.fromString(scanner.nextLine());

    library.borrowBook(memberId, bookId);

    System.out.println("Book borrowed.");
  }

  private void returnBook() {
    System.out.print("Member ID: ");
    UUID memberId = UUID.fromString(scanner.nextLine());

    System.out.print("Book ID: ");
    UUID bookId = UUID.fromString(scanner.nextLine());

    library.returnBook(memberId, bookId);

    System.out.println("Book returned.");
  }

  private void listBooks() {
    library.listBooks().forEach(System.out::println);
  }

  private void listMembers() {
    library.listMembers().forEach(System.out::println);
  }
}
