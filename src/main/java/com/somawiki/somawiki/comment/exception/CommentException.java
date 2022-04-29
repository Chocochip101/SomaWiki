package com.somawiki.somawiki.comment.exception;

public class CommentException extends Exception{
    public CommentException() {
        super("잘못된 댓글 정보입니다.");
    }

    public CommentException(String msg) {
        super(msg);
    }
}
