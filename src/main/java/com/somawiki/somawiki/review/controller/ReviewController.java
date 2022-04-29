package com.somawiki.somawiki.review.controller;

import com.somawiki.somawiki.review.dto.SimpleReviewDto;
import com.somawiki.somawiki.review.service.ReviewService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/reviews")
@RestController
public class ReviewController {
  private final ReviewService reviewService;

  @Operation(summary = "최신 후기")
  @GetMapping("/recent")
  public List<SimpleReviewDto> getRecentReviews() {
    List<SimpleReviewDto> reviewDtoList = reviewService.showRecentReviews(5);
    return reviewDtoList;
  }

  @Operation(summary = "인기 후기")
  @GetMapping("/popular")
  public List<SimpleReviewDto> getPopularReviews() {
    List<SimpleReviewDto> reviewDtoList = reviewService.showRecentReviews(5);
    return reviewDtoList;
  }
}
