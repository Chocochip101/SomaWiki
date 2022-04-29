package com.somawiki.somawiki.user.exception;

public class LoginException extends Exception {
  public LoginException() {
    super("로그인 정보가 틀렸습니다.");
  }

  public LoginException(String msg) {
    super(msg);
  }
}
