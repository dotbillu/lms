package com.lms;

import com.lms.model.*;
import com.lms.repository.BookRepository;

public class App {
  public static void main(String[] args) {
    Book book = new Book("Clean Code", "Robert Martin", "Programming");
    // Member member = new Member("Abhay", 22, "Male");
    BookRepository books = new BookRepository();
    books.add(book);

  }
}
