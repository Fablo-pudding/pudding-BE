package com.example.puddingbe.domain.comment.controller;

import com.example.puddingbe.domain.comment.entity.Comment;
import com.example.puddingbe.domain.comment.entity.dto.CommentRequestDTO;
import com.example.puddingbe.domain.comment.entity.dto.CommentResponseDTO;
import com.example.puddingbe.domain.comment.service.CommentCreateService;
import com.example.puddingbe.domain.comment.service.CommentDeleteService;
import com.example.puddingbe.domain.comment.service.CommentReadService;
import com.example.puddingbe.domain.comment.service.CommentUpdateService;
import com.oracle.svm.core.annotate.Delete;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {
    private final CommentCreateService commentCreateService;
    private final CommentReadService commentReadService;
    private final CommentUpdateService commentUpdateService;
    private final CommentDeleteService commentDeleteService;

    // 댓글 추가
    @PostMapping("/{post-id}")

    @ResponseStatus(HttpStatus.CREATED)
    public void createComment(@PathVariable Long postId, @RequestBody @Validated CommentRequestDTO dto) {
        commentCreateService.create(postId, dto);
    }

    // 댓글 읽어오기
    @GetMapping("/{postId}")
    public List<CommentResponseDTO> getComments(@PathVariable Long postId) {
        return commentReadService.getComments(postId);
    }

    // 댓글 수정
    @PatchMapping("/{commentId}")
    public void updateComment(@PathVariable Long commentId, @RequestBody @Validated CommentRequestDTO dto) {
        commentUpdateService.update(commentId, dto);
    }

    // 댓글 삭제 - 일단 임시로 path로 userId가져옴
    @DeleteMapping("/{commentId}/{userId}")
    public void deleteComment(@PathVariable Long commentId, @PathVariable Long userId) {
        commentDeleteService.Delete(commentId, userId);
    }
}
