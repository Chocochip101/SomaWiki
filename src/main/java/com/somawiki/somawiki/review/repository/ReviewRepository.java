package com.somawiki.somawiki.review.repository;

import com.somawiki.somawiki.review.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
