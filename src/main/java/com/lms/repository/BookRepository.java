package com.lms.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.lms.model.Book;

public class BookRepository {
  Map<UUID, Book> books = new HashMap<>();

  public void add(Book book) {
    this.books.put(book.getId(), book);
  }

  public Book findById(UUID id) {
    return this.books.get(id);
  }

  public List<Book> findAll() {
    ArrayList<Book> allBooks = new ArrayList<>();
    for (Book book : this.books.values()) {
      allBooks.addLast(book);
    }
    return allBooks;
  }

  public void delete(UUID id) {
    this.books.remove(id);
  }
}
