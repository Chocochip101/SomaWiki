package com.somawiki.somawiki.comment.dto;

import com.somawiki.somawiki.comment.domain.Comment;
import lombok.*;

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
