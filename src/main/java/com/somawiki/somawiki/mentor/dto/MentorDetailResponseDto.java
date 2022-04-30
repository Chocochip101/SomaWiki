package com.somawiki.somawiki.mentor.dto;

import com.somawiki.somawiki.review.domain.Review;
import com.somawiki.somawiki.review.dto.SimpleReviewDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class MentorDetailResponseDto {
  private long idx;
  private String name;
  private List<SimpleReviewDto> reviews;

  public MentorDetailResponseDto(long idx, String name, List<Review> reviewList) {
    this.idx = idx;
    this.name = name;
    this.reviews = new ArrayList<>();
    reviewList.stream().forEach(
      (item) -> {
        this.reviews.add(new SimpleReviewDto(item.getIdx(), item.getTitle(), item.getUser().getName()));
      }
    );
  }
}
