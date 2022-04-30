package com.somawiki.somawiki.user.exception;

public class NotLoggedInException extends RuntimeException {
    public NotLoggedInException(String msg) {
        super(msg);
    }
}
