package com.somawiki.somawiki.comment.dto;

import com.somawiki.somawiki.comment.domain.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentResponseDto {
    private long id;
    private String author;
    private String text;

    public CommentResponseDto(Comment comment){
        this.id = comment.getIdx();
        this.text = comment.getContent();
        this.author = comment.getUser().getName();
    }
}
