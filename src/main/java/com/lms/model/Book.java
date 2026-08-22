package com.lms.model;

public class Book {
  String id;
  String title;
  String author;
  String genre;
  BookStatus status;

  public Book(String id, String title, String author, String genre) {
    this.id = id;
    this.title = title;
    this.author = author;
    this.genre = genre;
    this.status = BookStatus.AVAILABLE;
  }
}
