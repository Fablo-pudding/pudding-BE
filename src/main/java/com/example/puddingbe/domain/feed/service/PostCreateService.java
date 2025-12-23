package com.example.puddingbe.domain.feed.service;

import com.example.puddingbe.domain.feed.domain.Post;
import com.example.puddingbe.domain.feed.exception.PostBadRequestExcpetion;
import com.example.puddingbe.domain.feed.presentation.dto.PostRequestDTO;
import com.example.puddingbe.domain.feed.domain.repository.PostRepository;
import com.example.puddingbe.global.detail.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class PostCreateService {
    private final PostRepository postRepository;
    private final UserFacade userFacade;

    public void createPost(PostRequestDTO dto){
        // null이거나 비어있거나 공백일 경우 400
        if (dto.getTitle().trim().isEmpty() || dto.getContent().trim().isEmpty()) {
            throw PostBadRequestExcpetion.EXCPETION;
        }

        Long userId = userFacade.getUserId();

        try {
            Post post = Post.builder()
                    .userId(userId)
                    .title(dto.getTitle())
                    .content(dto.getContent())
                    .build();

            postRepository.save(post);

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}