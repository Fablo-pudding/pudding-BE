package com.example.puddingbe.domain.comment.controller;

import com.example.puddingbe.domain.comment.entity.dto.CommentRequestDTO;
import com.example.puddingbe.domain.comment.service.CommentCreateService;
import com.example.puddingbe.domain.comment.service.CommentDeleteService;
import com.example.puddingbe.domain.comment.service.CommentUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {
    private final CommentCreateService commentCreateService;
    private final CommentUpdateService commentUpdateService;
    private final CommentDeleteService commentDeleteService;

    // 댓글 추가
    @PostMapping("/create/{post-id}")
    public ResponseEntity<Void> createComment(@PathVariable("post-id") Long postId, @RequestBody @Validated CommentRequestDTO dto) {
        commentCreateService.create(postId, dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    // 댓글 수정
    @PatchMapping("/update/{comment-id}")
    public ResponseEntity<Void> updateComment(@PathVariable("comment-id") Long commentId, @RequestBody @Validated CommentRequestDTO dto) {
        commentUpdateService.update(commentId, dto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    // 댓글 삭제 - 일단 임시로 path로 userId가져옴
    @DeleteMapping("/delete/{comment-id}/{user-id}")
    public ResponseEntity<Void> deleteComment(@PathVariable("comment-id") Long commentId, @PathVariable("user-id") Long userId) {
        commentDeleteService.Delete(commentId, userId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
