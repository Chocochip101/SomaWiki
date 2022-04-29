package com.somawiki.somawiki;

import com.somawiki.somawiki.exception.ErrorResponse;
import com.somawiki.somawiki.mentor.exception.WrongMentorException;
import com.somawiki.somawiki.user.exception.LoginException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserControllerAdvice {
  @ResponseStatus(HttpStatus.UNAUTHORIZED)
  @ExceptionHandler(LoginException.class)
  public ErrorResponse failToLoginHandle(LoginException e) {
    return new ErrorResponse(HttpStatus.UNAUTHORIZED, e.getMessage());
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(WrongMentorException.class)
  public ErrorResponse failToGetMentor(WrongMentorException e) {
    return new ErrorResponse(HttpStatus.BAD_REQUEST, e.getMessage());
  }
}
