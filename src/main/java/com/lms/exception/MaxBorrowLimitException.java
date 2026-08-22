package com.lms.exception;

public class MaxBorrowLimitException extends RuntimeException {
  public MaxBorrowLimitException(String message) {
    super(message);
  }
}
