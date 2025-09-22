package com.example.puddingbe.domain.feed.service;

import com.example.puddingbe.domain.feed.entity.Post;
import com.example.puddingbe.domain.feed.entity.dto.PostDetailResponseDTO;
import com.example.puddingbe.domain.feed.entity.dto.PostListResponseDTO;
import com.example.puddingbe.domain.feed.entity.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostReadService {
    private final PostRepository postRepository;

    //모두 가져오기, 자세한 내용(하나만) 가져오기
    public List<PostListResponseDTO> getPosts() {
        List<Post> posts = postRepository.findAll();

        //List<Post>타입을 List<PostResponse>타입으로 변경
        return posts.stream().map(post -> new PostListResponseDTO(
                post.getPostId(),
                post.getUserId(),
                post.getTitle(),
                post.getContent(),
                post.getCreatedAt()
        )).collect(Collectors.toList());
    }

    public PostDetailResponseDTO getPostDetail(Long postId){
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        try {
            return new PostDetailResponseDTO(
                    post.getPostId(),
                    post.getUserId(),
                    post.getTitle(),
                    post.getContent(),
                    post.getCreatedAt(),
                    post.getComments()
            );
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
