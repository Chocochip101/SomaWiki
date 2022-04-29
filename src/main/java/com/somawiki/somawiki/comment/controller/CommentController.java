package com.somawiki.somawiki.comment.controller;

import com.somawiki.somawiki.comment.dto.CommentRequestDto;
import com.somawiki.somawiki.comment.exception.CommentException;
import com.somawiki.somawiki.comment.service.CommentService;
import com.somawiki.somawiki.user.dto.LoginResponseDto;
import com.somawiki.somawiki.user.exception.LoginException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

public class CommentController {
    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }

    @ResponseBody
    @PostMapping("/reviews/{reviewIdx}/comments")
    public ResponseEntity saveComment(HttpServletRequest httpServletRequest,
                                         @RequestBody CommentRequestDto commentRequestDto,
                                         @PathVariable Long reviewIdx,@SessionAttribute LoginResponseDto loginUser,
                                         BindingResult result) throws CommentException {
        if (result.hasErrors()) {
            throw new CommentException("올바른 값을 입력하세요.");
        }
        // Post
        return ResponseEntity.ok(commentService.saveComment(loginUser.getIdx(), reviewIdx, commentRequestDto));
    }

    @ResponseBody
    @DeleteMapping("/reviews/{reviewIdx}/comments/{commentIdx}")
    public ResponseEntity<?> deleteComment(HttpServletRequest httpServletRequest,
                                           @PathVariable Long reviewIdx,
                                           @PathVariable Long commentIdx,@SessionAttribute LoginResponseDto loginUser,
                                           BindingResult result) throws CommentException {
        if (result.hasErrors()) {
            throw new CommentException("올바른 값을 입력하세요.");
        }
        // Post
        return ResponseEntity.ok(commentService.deleteComment(loginUser.getIdx(), reviewIdx, commentIdx));
    }
}
