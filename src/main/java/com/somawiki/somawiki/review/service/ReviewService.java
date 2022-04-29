package com.somawiki.somawiki.review.service;

import com.somawiki.somawiki.review.domain.Review;
import com.somawiki.somawiki.review.dto.SimpleReviewDto;
import com.somawiki.somawiki.review.repository.ReviewJpqlRepository;
import com.somawiki.somawiki.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ReviewService {
  private final ReviewJpqlRepository reviewJpqlRepository;

  public List<SimpleReviewDto> showRecentReviews(int size) {
    List<Review> rawList = reviewJpqlRepository.findAllDesc(size);
    List<SimpleReviewDto> result = new ArrayList<>();

    rawList.stream().forEach(
      (item) -> {
        result.add(new SimpleReviewDto(item));
      }
    );

    return result;
  }

}
