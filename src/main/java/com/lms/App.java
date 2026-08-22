package com.lms;

import com.lms.cli.LibraryCLI;
import com.lms.repository.BookRepository;
import com.lms.repository.MemberRepository;
import com.lms.service.Library;

public class App {
  public static void main(String[] args) {
    BookRepository bookRepository = new BookRepository();
    MemberRepository memberRepository = new MemberRepository();
    Library library = new Library(bookRepository, memberRepository);
    LibraryCLI cli = new LibraryCLI(library);
    cli.start();

  }
}
