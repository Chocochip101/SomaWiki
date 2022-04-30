package com.somawiki.somawiki.comment.service;

import com.somawiki.somawiki.comment.domain.Comment;
import com.somawiki.somawiki.comment.dto.CommentRequestDto;
import com.somawiki.somawiki.comment.repository.CommentRepository;
import com.somawiki.somawiki.review.domain.Review;
import com.somawiki.somawiki.review.repository.ReviewRepository;
import com.somawiki.somawiki.user.domain.User;
import com.somawiki.somawiki.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final ReviewRepository reviewRepository;

    @Transactional
    public void saveComment(Long userIdx, Long reviewIdx, CommentRequestDto commentRequestDto){
        User user = userRepository.findByIdx(userIdx);
        Review review = reviewRepository.findById(reviewIdx).orElseThrow(()->
             new IllegalArgumentException("댓글 쓰기 실패했습니다."));
        Comment comment = new Comment(commentRequestDto.getText(), user, review);
        commentRepository.save(comment);
    }

    public void deleteComment(Long userIdx, Long commentIdx) {
        Comment comment = commentRepository.findById(commentIdx).orElseThrow(()->
                new IllegalArgumentException("해당 댓글이 존재하지 않습니다."));
        if (!comment.isWrittenBy(userIdx)) {
            throw new RuntimeException("해당 댓글에 대한 작성자가 아닙니다.");
        }
        commentRepository.delete(comment);
    }
}
