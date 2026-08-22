package com.lms.model;

import java.util.UUID;

public class Book {
  UUID id;
  String title;
  String author;
  String genre;
  BookStatus status;

  public Book(String title, String author, String genre) {
    this.id = UUID.randomUUID();
    this.title = title;
    this.author = author;
    this.genre = genre;
    this.status = BookStatus.AVAILABLE;
  }

  public UUID getId() {
    return this.id;
  }

  public void updateStatus(BookStatus status) {
    this.status = status;
  }

  public BookStatus getStatus() {
    return this.status;
  }

  @Override
  public String toString() {
    return "Book{" +
        "id=" + id +
        ", title='" + title + '\'' +
        ", author='" + author + '\'' +
        ", genre='" + genre + '\'' +
        ", status=" + status +
        '}';
  }
}
