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
public class PostCreateService {
    private final PostRepository postRepository;

    public void createPost(PostRequestDTO dto){
        // null이거나 비어있거나 공백일 경우 400
        if (dto.getTitle() == null || dto.getContent() == null || dto.getTitle().trim().isEmpty() || dto.getContent().trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        try {
            Post post = Post.builder()
                    .userId(dto.getUserId())
                    .title(dto.getTitle())
                    .content(dto.getContent())
                    .build();

            postRepository.save(post);

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}