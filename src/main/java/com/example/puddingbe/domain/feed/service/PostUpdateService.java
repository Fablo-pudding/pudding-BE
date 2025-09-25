package com.example.puddingbe.domain.feed.service;

import com.example.puddingbe.domain.feed.entity.Post;
import com.example.puddingbe.domain.feed.entity.dto.PostRequestDTO;
import com.example.puddingbe.domain.feed.entity.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class PostUpdateService {
    private final PostRepository postRepository;


    public void updatePost(Long postId, PostRequestDTO req){
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        // 유저 확인
        if(!post.getUserId().equals(req.getUserId())){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }

        post.update(req.getTitle(), req.getContent());
        postRepository.save(post);
    }
}
