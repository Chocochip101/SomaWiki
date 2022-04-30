package com.somawiki.somawiki.exception;

import com.somawiki.somawiki.mentor.exception.WrongMentorException;
import com.somawiki.somawiki.review.exception.WrongReviewException;
import com.somawiki.somawiki.user.exception.LoginException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;

@RestControllerAdvice
@Slf4j
public class ControllerAdvice {
  @ResponseStatus(HttpStatus.UNAUTHORIZED)
  @ExceptionHandler(LoginException.class)
  public ErrorResponse failToLoginHandle(LoginException e) {
    log.info(e.getMessage());
    return new ErrorResponse(HttpStatus.UNAUTHORIZED, e.getMessage());
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(WrongMentorException.class)
  public ErrorResponse failToGetMentor(WrongMentorException e) {
    log.info(e.getMessage());
    return new ErrorResponse(HttpStatus.BAD_REQUEST, e.getMessage());
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(WrongReviewException.class)
  public ErrorResponse failToGetReview(WrongReviewException e) {
    log.info(e.getMessage());
    return new ErrorResponse(HttpStatus.BAD_REQUEST, e.getMessage());
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(Exception.class)
  public ErrorResponse general(Exception e) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(e.getMessage());
    for (String message : Arrays.toString(e.getStackTrace()).split(",")) {
      stringBuilder.append(message).append("\n");
    }
    log.error(stringBuilder.toString());
    return new ErrorResponse(HttpStatus.BAD_REQUEST, e.getMessage());
  }
}
