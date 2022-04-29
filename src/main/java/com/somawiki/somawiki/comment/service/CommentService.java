package com.somawiki.somawiki.comment.service;

import com.somawiki.somawiki.comment.domain.Comment;
import com.somawiki.somawiki.comment.dto.CommentRequestDto;
import com.somawiki.somawiki.comment.repository.CommentRepository;
import com.somawiki.somawiki.review.domain.Review;
import com.somawiki.somawiki.review.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.Optional;

public class CommentService {
    private final CommentRepository commentRepository;
    private final ReviewRepository reviewRepository;
    @Autowired
    public CommentService(CommentRepository commentRepository,ReviewRepository reviewRepository){
        this.commentRepository = commentRepository;
        this.reviewRepository = reviewRepository;
    }

    public boolean createComment(CommentRequestDto commentRequestDto, Long reviewIdx){
        return true;
    }
    public boolean deleteComment(Long reviewIdx, Long commentIdx){

        return false;
    }
}
