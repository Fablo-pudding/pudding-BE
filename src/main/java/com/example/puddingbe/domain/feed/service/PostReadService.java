package com.example.puddingbe.domain.feed.service;

import com.example.puddingbe.domain.feed.entity.Post;
import com.example.puddingbe.domain.feed.entity.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostReadService {
    private final PostRepository postRepository;

    //모두 가져오기, 자세한 내용(하나만) 가져오기
    public List<Post> getPostList() {
        List<Post> posts = postRepository.findAll();

        return posts;
    }

    public Post getPostDetail(Long postId){
        Post post = postRepository.findById(postId).orElseThrow();

        return post;
    }
}
