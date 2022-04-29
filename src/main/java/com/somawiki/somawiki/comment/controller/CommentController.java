package com.somawiki.somawiki.comment.controller;

import com.somawiki.somawiki.comment.dto.CommentRequestDto;
import com.somawiki.somawiki.comment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class CommentController {
    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }

    @ResponseBody
    @PostMapping("/reviews/{reviewIdx}/comments")
    public ResponseEntity<?> saveComment(@RequestBody CommentRequestDto commentRequestDto, @PathVariable Long reviewIdx){
        //jwt

        // Post

    }

    @ResponseBody
    @DeleteMapping("/reviews/{reviewIdx}/comments/{commentIdx}")
    public ResponseEntity<?> deleteComment(){

    }
}
