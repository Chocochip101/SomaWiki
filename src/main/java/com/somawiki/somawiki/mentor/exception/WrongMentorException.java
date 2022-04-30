package com.somawiki.somawiki.mentor.exception;

public class WrongMentorException extends RuntimeException {

  public WrongMentorException() {
    super("멘토 id 값이 잘못 되었습니다.");
  }

  public WrongMentorException(String msg) {
    super(msg);
  }
}
