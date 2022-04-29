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
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    List<SimpleReviewDto> reviewDtoList = reviewService.showPopularReviews(5);
    return reviewDtoList;
  }

  @Operation(summary = "후기 디테일")
  @GetMapping("/{reviewId}")
  public ReviewDetailDto getReviewDetail(@PathVariable long reviewId) throws WrongReviewException {
    ReviewDetailDto reviewDetailDto = reviewService.showReviewDetail(reviewId);

    if (reviewDetailDto == null) {
      throw new WrongReviewException();
    }

    return  reviewDetailDto;
  }

  @Operation(summary = "후기 작성")
  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping
  public void createNewReview(@RequestBody ReviewRequestDto requestDto,
                              @Parameter(hidden = true) @SessionAttribute LoginResponseDto loginUser) throws WrongMentorException {
    boolean isSucceed = reviewService.addNewReview(requestDto, loginUser);
    if (!isSucceed) {
      throw new WrongMentorException();

    }
  }


}
