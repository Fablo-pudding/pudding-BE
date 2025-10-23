package com.example.puddingbe.domain.comment.service;

import com.example.puddingbe.domain.comment.entity.Comment;
import com.example.puddingbe.domain.comment.presentation.dto.CommentRequestDTO;
import com.example.puddingbe.domain.comment.entity.repository.CommentRepository;
import com.example.puddingbe.global.detail.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class CommentUpdateService {
    private final CommentRepository commentRepository;
    private final UserFacade userFacade;

    @Transactional
    public void update(Long commentId, CommentRequestDTO dto) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        Long userId = userFacade.getUserId();

        if(!comment.getUserId().equals(userId)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }

        comment.update(dto.getContent());
        commentRepository.save(comment);
    }
}
