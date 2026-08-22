package com.lms.model;

import java.util.ArrayList;
import java.util.List;

public class Member extends Person {
  List<Book> books;

  public Member(String name, int age, String gender) {
    super(name, age, gender);
    this.books = new ArrayList<Book>();
  }

  public void addBook(Book book) {
    this.books.add(book);
  }

  public void remove(Book book) {
    this.books.remove(book);
  }

  public Integer booksCount() {
    return this.books.size();
  }

  public Boolean hasBook(Book book) {
    return this.books.contains(book);
  }

}
