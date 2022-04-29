package com.somawiki.somawiki.review.dto;

import com.somawiki.somawiki.comment.domain.Comment;
import com.somawiki.somawiki.comment.dto.CommentResponseDto;
import com.somawiki.somawiki.mentor.dto.MentorSimpleDto;
import com.somawiki.somawiki.review.domain.Review;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDetailDto {
  private long id;
  private String title;
  private String author;
  private MentorSimpleDto mentor;
  private String link;
  private String summary;
  private LocalDateTime createdDate;
  private long views;
  private List<CommentResponseDto> comments;

  public void updateFieldsWithoutComments(Review review) {
    this.id = review.getIdx();
    this.title = review.getTitle();
    this.author = review.getUser().getName();
    this.mentor = new MentorSimpleDto(review.getMentor());
    this.link = review.getLink();
    this.summary = review.getSummary();
    this.createdDate = review.getCreatedDate();
    this.views = review.getViews();
  }

  public void updateCommentsWithEntity(List<Comment> commentsWithEntity) {
    comments = new ArrayList<>();
    for (Comment comment : commentsWithEntity) {
      comments.add(new CommentResponseDto(comment));
    }
  }
}
