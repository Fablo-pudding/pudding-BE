package com.example.puddingbe.domain.comment.service;

import com.example.puddingbe.domain.comment.domain.Comment;
import com.example.puddingbe.domain.comment.domain.repository.CommentRepository;
import com.example.puddingbe.domain.comment.exception.CommentNotFoundException;
import com.example.puddingbe.domain.comment.exception.CommentOnlyAuthorDeleteException;
import com.example.puddingbe.global.detail.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class CommentDeleteService {
    private final CommentRepository commentRepository;
    private final UserFacade userFacade;

    public void Delete(Long commentId) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> CommentNotFoundException.EXCEPTION);
        Long userId = userFacade.getUserId();

        if(!comment.getUserId().equals(userId)) {
            throw CommentOnlyAuthorDeleteException.EXCEPTION;
        }

        commentRepository.delete(comment);
    }
}
