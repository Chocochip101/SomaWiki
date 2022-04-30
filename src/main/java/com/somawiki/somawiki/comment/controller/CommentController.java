package com.somawiki.somawiki.comment.controller;

import com.somawiki.somawiki.comment.dto.CommentRequestDto;
import com.somawiki.somawiki.comment.service.CommentService;
import com.somawiki.somawiki.user.dto.LoginResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Tag(name = "CommentController", description = "댓글 관련 API")
@RequiredArgsConstructor
@RestController
public class CommentController {
    private final CommentService commentService;

    @Operation(summary = "댓글 저장")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/reviews/{reviewIdx}/comments")
    public void saveComment(@PathVariable Long reviewIdx,
                            @Validated @RequestBody CommentRequestDto commentRequestDto,
                            BindingResult result,
                            @Parameter(hidden = true) @SessionAttribute LoginResponseDto loginUser) {
        validateBindingResult(result);
        commentService.saveComment(loginUser.getIdx(), reviewIdx, commentRequestDto);
    }

    private void validateBindingResult(BindingResult result) {
        if (result.hasErrors()) {
            throw new RuntimeException("올바른 값을 입력하세요.");
        }
    }

    @Operation(summary = "댓글 삭제")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/reviews/{reviewIdx}/comments/{commentIdx}")
    public void deleteComment(@PathVariable Long reviewIdx,
                              @PathVariable Long commentIdx,
                              @Parameter(hidden = true) @SessionAttribute LoginResponseDto loginUser,
                              HttpServletRequest httpServletRequest) throws Exception {
        commentService.deleteComment(loginUser.getIdx(), commentIdx);
    }
}
