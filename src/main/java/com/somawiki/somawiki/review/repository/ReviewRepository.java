package com.somawiki.somawiki.review.repository;

import com.somawiki.somawiki.mentor.domain.Mentor;
import com.somawiki.somawiki.review.domain.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    Page<Review> findAll(Pageable pageable);
    Page<Review> findReviewsByMentor(Mentor mentor, Pageable pageable);


}
