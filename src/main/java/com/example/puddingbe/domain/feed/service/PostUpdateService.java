package com.example.puddingbe.domain.feed.service;

import com.example.puddingbe.domain.feed.entity.Post;
import com.example.puddingbe.domain.feed.entity.dto.PostRequestDTO;
import com.example.puddingbe.domain.feed.entity.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PostUpdateService {
    private final PostRepository postRepository;


    public void updatePost(Long postId, PostRequestDTO req){
        Post post = postRepository.findById(postId).orElseThrow(() -> new IllegalArgumentException("게시글을 찾을 수 없음"));

        // 유저 확인
        if(!post.getPostId().equals(req.getUserId())){
            throw new IllegalArgumentException("권한 없음");
        }

        post.update(req.getTitle(), req.getContent());
    }
}
