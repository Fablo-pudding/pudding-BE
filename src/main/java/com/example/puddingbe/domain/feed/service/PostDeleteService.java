package com.example.puddingbe.domain.feed.service;

import com.example.puddingbe.domain.feed.entity.Post;
import com.example.puddingbe.domain.feed.entity.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class PostDeleteService {
    private final PostRepository postRepository;

    public void delete(Long postId, Long userId){
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        try
        {
            // userId 맞는지 확인
            if (!post.getUserId().equals(userId)) {
                throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
            }

            postRepository.delete(post);

        }catch (Exception e) {
            throw  new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
