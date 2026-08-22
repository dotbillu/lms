package com.lms;

import com.lms.model.*;

public class App {
  public static void main(String[] args) {
    Book book = new Book("1", "Clean Code", "Robert Martin", "Programming");
    Member member = new Member("Abhay", 22, "Male");
    System.out.println(book);
    System.out.println(member);

  }
}
