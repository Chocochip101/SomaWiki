package com.somawiki.somawiki.comment.dto;

import com.somawiki.somawiki.comment.domain.Comment;
import com.somawiki.somawiki.review.domain.Review;
import com.somawiki.somawiki.user.domain.User;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentRequestDto {
    private Long idx;
    private String text;

    private User user;
    private Review review;

    public Comment toEntity(){
        Comment comments = Comment.builder()
                .idx(idx)
                .content(text)
                .user(user)
                .review(review)
                .build();
        return comments;
    }
}
