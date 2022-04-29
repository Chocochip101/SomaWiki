package com.somawiki.somawiki.review.dto;

import com.somawiki.somawiki.review.domain.Review;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SimpleReviewDto {
  private long idx;
  private String title;
  private String author;

  public SimpleReviewDto(Review review) {
    this.idx = review.getIdx();
    this.title = review.getTitle();
    this.author = review.getUser().getName();
  }
}
