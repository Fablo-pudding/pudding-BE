package com.example.puddingbe.domain.comment.service;

import com.example.puddingbe.domain.comment.entity.Comment;
import com.example.puddingbe.domain.comment.entity.dto.CommentResponseDTO;
import com.example.puddingbe.domain.feed.entity.Post;
import com.example.puddingbe.domain.feed.entity.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentReadService {
    private final PostRepository postRepository;

    public List<CommentResponseDTO> getComments(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new IllegalArgumentException("게시글을 찾을 수 없음"));

        // List<Comment> to List<CommentResponseDTO>
        return post.getComments().stream().map(comment -> new CommentResponseDTO(
                comment.getUser_id(), comment.getContent(), comment.getCreatedAt()
                )).collect(Collectors.toList());
    }
}
