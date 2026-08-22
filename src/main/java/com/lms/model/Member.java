package com.lms.model;

import java.util.ArrayList;
import java.util.List;

public class Member extends Person {
  List<Book> books;

  public Member(String name, int age, String gender) {
    super(name, age, gender);
    this.books = new ArrayList<Book>();
    System.out.println("Member created: " + this.id);
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

  @Override
  public String toString() {
    return "Member{" +
        "id=" + getId() +
        ", name='" + name + '\'' +
        ", age=" + age +
        ", gender='" + gender + '\'' +
        '}';
  }
}
