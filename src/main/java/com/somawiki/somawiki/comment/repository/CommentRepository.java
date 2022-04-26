package com.somawiki.somawiki.comment.repository;

import com.somawiki.somawiki.comment.domain.Comment;
import com.somawiki.somawiki.review.domain.Review;
import com.somawiki.somawiki.user.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    Page<Comment> findAll(Pageable pageable);
    Page<Comment> findCommentsByReview(Review review, Pageable pageable);
    Page<Comment> findCommentsByUser(User user, Pageable pageable);
}
