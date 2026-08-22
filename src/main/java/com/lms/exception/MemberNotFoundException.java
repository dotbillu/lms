package com.lms.exception;

public class MemberNotFoundException extends RuntimeException {
  public MemberNotFoundException(String message) {
    super(message);
  }

  public MemberNotFoundException() {
    super("Member not found");
  }

}
