package com.somawiki.somawiki.review.controller;

import com.somawiki.somawiki.mentor.exception.WrongMentorException;
import com.somawiki.somawiki.review.dto.ReviewDetailDto;
import com.somawiki.somawiki.review.dto.ReviewRequestDto;
import com.somawiki.somawiki.review.dto.SimpleReviewDto;
import com.somawiki.somawiki.review.exception.WrongReviewException;
import com.somawiki.somawiki.review.service.ReviewService;
import com.somawiki.somawiki.user.dto.LoginResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "ReviewController", description = "후기 관련 API")
@RequiredArgsConstructor
@RestController
public class ReviewController {
  private final ReviewService reviewService;

  @Operation(summary = "최신 후기")
  @GetMapping("/reviews/recent")
  public List<SimpleReviewDto> getRecentReviews() {
    return reviewService.showRecentReviews(5);
  }

  @Operation(summary = "인기 후기")
  @GetMapping("/reviews/popular")
  public List<SimpleReviewDto> getPopularReviews() {
    return reviewService.showPopularReviews(5);
  }

  @Operation(summary = "후기 디테일")
  @GetMapping("/reviews/{reviewId}")
  public ReviewDetailDto getReviewDetail(@PathVariable long reviewId) throws WrongReviewException {
    return reviewService.showReviewDetail(reviewId);
  }

  @Operation(summary = "후기 작성")
  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping("/reviews")
  public void createNewReview(@Validated @RequestBody ReviewRequestDto requestDto,
                              BindingResult bindingResult,
                              @Parameter(hidden = true) @SessionAttribute LoginResponseDto loginUser) {
    validateBindingResult(bindingResult);
    reviewService.addNewReview(requestDto, loginUser);
  }

  @Operation(summary = "후기 삭제")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @DeleteMapping("/reviews/{reviewId}")
  public void deleteReview(@PathVariable long reviewId,
                           @Parameter(hidden = true) @SessionAttribute LoginResponseDto loginUser) {
    reviewService.deleteReview(reviewId, loginUser);
  }

  private void validateBindingResult(BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      throw new RuntimeException("입력된 값이 올바르지 않습니다.");
    }
  }
}
