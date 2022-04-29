package com.somawiki.somawiki.comment.dto;

import com.somawiki.somawiki.comment.domain.Comment;
import com.somawiki.somawiki.review.domain.Review;
import com.somawiki.somawiki.user.domain.User;
import lombok.*;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentRequestDto {
    @NotEmpty
    private String text;
}
