package com.somawiki.somawiki.comment.service;

import com.somawiki.somawiki.comment.domain.Comment;
import com.somawiki.somawiki.comment.dto.CommentRequestDto;
import com.somawiki.somawiki.comment.repository.CommentRepository;
import com.somawiki.somawiki.review.domain.Review;
import com.somawiki.somawiki.review.repository.ReviewRepository;
import com.somawiki.somawiki.user.domain.User;
import com.somawiki.somawiki.user.exception.LoginException;
import com.somawiki.somawiki.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final ReviewRepository reviewRepository;

    @Transactional
    public boolean saveComment(Long UserIdx, Long reviewIdx, CommentRequestDto commentRequestDto){
        User user = userRepository.findByIdx(UserIdx);
        Review review = reviewRepository.findById(reviewIdx).orElseThrow(()->
             new IllegalArgumentException("댓글 쓰기 실패했습니다."));

        commentRequestDto.setUser(user);
        commentRequestDto.setReview(review);

        Comment comment = commentRequestDto.toEntity();
        commentRepository.save(comment);

        return true;
    }
    public boolean deleteComment(Long UserIdx, Long reviewIdx, Long commentIdx){
        Comment comment = commentRepository.findById(commentIdx).orElseThrow(()->
                new IllegalArgumentException("해당 댓글이 존재하지 않습니다."));

        commentRepository.delete(comment);
        return true;
    }
}
