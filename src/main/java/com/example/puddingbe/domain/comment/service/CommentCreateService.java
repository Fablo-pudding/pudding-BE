package com.example.puddingbe.domain.comment.service;

import com.example.puddingbe.domain.comment.entity.Comment;
import com.example.puddingbe.domain.comment.entity.dto.CommentRequestDTO;
import com.example.puddingbe.domain.comment.entity.repository.CommentRepository;
import com.example.puddingbe.domain.feed.entity.Post;
import com.example.puddingbe.domain.feed.entity.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentCreateService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    public void create(Long postId, CommentRequestDTO dto){
        Post post = postRepository.findById(postId).orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않음"));

        Comment comment = Comment.builder()
                .post(post)
                .content(dto.getContent())
                .userId(dto.getUser_id())
                .build();

        commentRepository.save(comment);
    }
}
