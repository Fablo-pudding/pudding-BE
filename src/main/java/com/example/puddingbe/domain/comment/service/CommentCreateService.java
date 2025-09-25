package com.example.puddingbe.domain.comment.service;

import com.example.puddingbe.domain.comment.entity.Comment;
import com.example.puddingbe.domain.comment.entity.dto.CommentRequestDTO;
import com.example.puddingbe.domain.comment.entity.repository.CommentRepository;
import com.example.puddingbe.domain.feed.entity.Post;
import com.example.puddingbe.domain.feed.entity.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class CommentCreateService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    public void create(Long postId, CommentRequestDTO dto){
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (dto.getContent() == null || dto.getContent().trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        try {
            Comment comment = Comment.builder()
                    .postId(post.getPostId())
                    .userId(dto.getUserId())
                    .content(dto.getContent())
                    .build();

            commentRepository.save(comment);
        }catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
