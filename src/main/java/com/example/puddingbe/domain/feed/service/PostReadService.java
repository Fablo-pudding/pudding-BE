package com.example.puddingbe.domain.feed.service;

import com.example.puddingbe.domain.feed.entity.Post;
import com.example.puddingbe.domain.feed.entity.dto.PostRequestDTO;
import com.example.puddingbe.domain.feed.entity.dto.PostResponseDTO;
import com.example.puddingbe.domain.feed.entity.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostReadService {
    private final PostRepository postRepository;

    //모두 가져오기, 자세한 내용(하나만) 가져오기
    public List<PostResponseDTO> getPosts() {
        List<Post> posts = postRepository.findAll();

        //List<Post>타입을 List<PostResponse>타입으로 변경
        return posts.stream().map(post -> new PostResponseDTO(
                post.getPostId(), post.getUserId(), post.getTitle(), post.getContent(), post.getCreatedAt()
        )).collect(Collectors.toList());
    }

    public Post getPostDetail(Long postId){
        Post post = postRepository.findById(postId).orElseThrow();

        return post;
    }
}
