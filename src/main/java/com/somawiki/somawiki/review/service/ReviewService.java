package com.somawiki.somawiki.review.service;

import com.somawiki.somawiki.comment.domain.Comment;
import com.somawiki.somawiki.comment.repository.CommentJpqlRepository;
import com.somawiki.somawiki.review.domain.Review;
import com.somawiki.somawiki.review.dto.ReviewDetailDto;
import com.somawiki.somawiki.review.dto.SimpleReviewDto;
import com.somawiki.somawiki.review.repository.ReviewJpqlRepository;
import com.somawiki.somawiki.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ReviewService {
  private final ReviewJpqlRepository reviewJpqlRepository;
  private final ReviewRepository reviewRepository;
  private final CommentJpqlRepository commentJpqlRepository;

  public List<SimpleReviewDto> showRecentReviews(int size) {
    List<Review> rawList = reviewJpqlRepository.findAllOrderByCreatedDateDesc(size);
    List<SimpleReviewDto> result = new ArrayList<>();

    rawList.stream().forEach(
      (item) -> {
        result.add(new SimpleReviewDto(item));
      }
    );

    return result;
  }

  public List<SimpleReviewDto> showPopularReviews(int size) {
    List<Review> rawList = reviewJpqlRepository.findAllOrderByViewsDesc(size);
    List<SimpleReviewDto> result = new ArrayList<>();

    rawList.stream().forEach(
      (item) -> {
        result.add(new SimpleReviewDto(item));
      }
    );

    return result;
  }

  public ReviewDetailDto showReviewDetail(long id) {
    Optional<Review> review = reviewRepository.findById(id);
    List<Comment> commentList;
    ReviewDetailDto reviewDetailDto;

    if (review.isEmpty()) {
      return null;
    }
    commentList = commentJpqlRepository.findAllByReview(review.get());

    reviewDetailDto = new ReviewDetailDto();
    reviewDetailDto.updateFieldsWithoutComments(review.get());
    reviewDetailDto.updateCommentsWithEntity(commentList);

    return reviewDetailDto;
  }

}
