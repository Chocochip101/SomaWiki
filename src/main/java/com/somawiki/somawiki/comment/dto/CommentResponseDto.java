package com.somawiki.somawiki.comment.dto;

import com.somawiki.somawiki.comment.domain.Comment;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class CommentResponseDto {
    private Long idx;
    private String author;
    private String text;
    private Long reviewIdx;

    public CommentResponseDto(Comment comment){
        this.idx = comment.getIdx();
        this.text = comment.getContent();
        this.author = comment.getUser().getName();
        this.reviewIdx = comment.getReview().getIdx();
    }
}
