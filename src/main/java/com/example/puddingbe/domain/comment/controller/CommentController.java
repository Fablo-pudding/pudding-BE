package com.example.puddingbe.domain.comment.controller;

import com.example.puddingbe.domain.comment.entity.dto.CommentRequestDTO;
import com.example.puddingbe.domain.comment.service.CommentCreateService;
import com.example.puddingbe.domain.comment.service.CommentDeleteService;
import com.example.puddingbe.domain.comment.service.CommentUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {
    private final CommentCreateService commentCreateService;
    private final CommentUpdateService commentUpdateService;
    private final CommentDeleteService commentDeleteService;

    // 댓글 추가
    @PostMapping("/create/{post-id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void createComment(@PathVariable("post-id") Long postId, @RequestBody @Validated CommentRequestDTO dto) {
        commentCreateService.create(postId, dto);
    }

    // 댓글 수정
    @PatchMapping("/update/{comment-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateComment(@PathVariable("comment-id") Long commentId, @RequestBody @Validated CommentRequestDTO dto) {
        commentUpdateService.update(commentId, dto);
    }

    // 댓글 삭제
    @DeleteMapping("/delete/{comment-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteComment(@PathVariable("comment-id") Long commentId) {
        commentDeleteService.Delete(commentId);
    }
    
}
