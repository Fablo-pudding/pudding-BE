package com.example.puddingbe.domain.comment.controller;

import com.example.puddingbe.domain.comment.entity.dto.CommentRequestDTO;
import com.example.puddingbe.domain.comment.service.CommentCreateService;
import com.example.puddingbe.domain.comment.service.CommentDeleteService;
import com.example.puddingbe.domain.comment.service.CommentUpdateService;
import com.example.puddingbe.domain.user.repository.UserRepository;
import com.example.puddingbe.global.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {
    private final CommentCreateService commentCreateService;
    private final CommentUpdateService commentUpdateService;
    private final CommentDeleteService commentDeleteService;
    private final JwtTokenProvider tokenProvider;
    private final UserRepository userRepository;

    // 댓글 추가
    @PostMapping("/create/{post-id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void createComment(@PathVariable("post-id") Long postId, @RequestBody @Validated CommentRequestDTO dto, @RequestHeader("Authorization") String token) {
        commentCreateService.create(postId, dto, getUserId(token));
    }

    // 댓글 수정
    @PatchMapping("/update/{comment-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateComment(@PathVariable("comment-id") Long commentId, @RequestBody @Validated CommentRequestDTO dto, @RequestHeader("Authorization") String token) {
        commentUpdateService.update(commentId, dto, getUserId(token));
    }

    // 댓글 삭제
    @DeleteMapping("/delete/{comment-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteComment(@PathVariable("comment-id") Long commentId, @RequestHeader("Authorization") String token) {
        commentDeleteService.Delete(commentId, getUserId(token));
    }

    private Long getUserId(String token) {
        String name;
        try {
            if (token.startsWith("Bearer ")) {
                name = tokenProvider.getNameFromToken(token.substring(7).trim());
            } else {
                name = tokenProvider.getNameFromToken(token.trim());
            }
            return userRepository.findByName(name).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)).getId();
        }catch (ResponseStatusException e){
            throw e;
        }catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
    }
}
