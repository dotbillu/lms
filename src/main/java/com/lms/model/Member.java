package com.lms.model;

import java.util.ArrayList;
import java.util.List;

public class Member extends Person {
  List<Book> books;

  public Member(String name, int age, String gender) {
    super(name, age, gender);
    this.books = new ArrayList<Book>();
  }
}
