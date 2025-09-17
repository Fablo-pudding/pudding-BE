package com.example.puddingbe.domain.comment.service;

import com.example.puddingbe.domain.comment.entity.Comment;
import com.example.puddingbe.domain.comment.entity.dto.CommentRequestDTO;
import com.example.puddingbe.domain.comment.entity.repository.CommentRepository;
import com.example.puddingbe.domain.feed.entity.Post;
import com.example.puddingbe.domain.feed.entity.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentUpdateService {
    private final CommentRepository commentRepository;
    private static final Logger logger = LoggerFactory.getLogger(AutoCloseable.class);

    @Transactional
    public void update(Long commentId, CommentRequestDTO dto) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new IllegalArgumentException("댓글이 존재하지 않음"));

        if(!comment.getUser_id().equals(dto.getUser_id())) {
            throw new IllegalArgumentException("수정 권한이 없는 유저");
        }

        logger.debug("아잉오잉오잉오"+dto.getContent());
        comment.update(dto.getContent());
    }
}
