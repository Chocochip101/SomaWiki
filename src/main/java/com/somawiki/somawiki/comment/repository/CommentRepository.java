package com.somawiki.somawiki.comment.repository;

import com.somawiki.somawiki.comment.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
