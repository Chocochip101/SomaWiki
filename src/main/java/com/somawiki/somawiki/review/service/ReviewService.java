package com.somawiki.somawiki.review.service;

import com.somawiki.somawiki.comment.domain.Comment;
import com.somawiki.somawiki.comment.repository.CommentJpqlRepository;
import com.somawiki.somawiki.mentor.domain.Mentor;
import com.somawiki.somawiki.mentor.repository.MentorRepository;
import com.somawiki.somawiki.review.domain.Review;
import com.somawiki.somawiki.review.dto.ReviewDetailDto;
import com.somawiki.somawiki.review.dto.ReviewRequestDto;
import com.somawiki.somawiki.review.dto.SimpleReviewDto;
import com.somawiki.somawiki.review.repository.ReviewJpqlRepository;
import com.somawiki.somawiki.review.repository.ReviewRepository;
import com.somawiki.somawiki.user.domain.User;
import com.somawiki.somawiki.user.dto.LoginResponseDto;
import com.somawiki.somawiki.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ReviewService {
  private final ReviewJpqlRepository reviewJpqlRepository;
  private final ReviewRepository reviewRepository;
  private final CommentJpqlRepository commentJpqlRepository;
  private final UserRepository userRepository;
  private final MentorRepository mentorRepository;

  @Transactional
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

  @Transactional
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

  @Transactional
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

  @Transactional
  public boolean addNewReview(ReviewRequestDto requestDto, LoginResponseDto loginUser) {
    User user = userRepository.findByIdx(loginUser.getIdx());
    Mentor mentor = mentorRepository.findByIdx(requestDto.getMentor());

    if (mentor == null) {
      return false;
    }

    Review review = new Review(requestDto.getTitle(), requestDto.getLink(),
                              requestDto.getSummary(), 0, user, mentor);
    reviewJpqlRepository.save(review);

    return true;
  }

}
