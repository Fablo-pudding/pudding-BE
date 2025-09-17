package com.example.puddingbe.domain.feed.service;

import com.example.puddingbe.domain.feed.entity.Post;
import com.example.puddingbe.domain.feed.entity.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostDeleteService {
    private final PostRepository postRepository;

    public void delete(Long postId, Long userId){
        Post post = postRepository.findById(postId).orElseThrow(() -> new IllegalArgumentException("게시글을 찾을 수 없음"));

        // userId 맞는지 확인
        if(!post.getPostId().equals(userId)){
            throw new IllegalArgumentException("권한없음");
        }

        postRepository.delete(post);
    }
}
