package com.somawiki.somawiki.review.exception;

public class WrongReviewException extends RuntimeException {

  public WrongReviewException() {
    super("후기 id 값이 잘못되었습니다.");
  }

  public WrongReviewException(String msg) {
    super(msg);
  }
}
