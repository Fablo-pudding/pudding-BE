package com.example.puddingbe.domain.feed.service;

import com.example.puddingbe.domain.feed.domain.Post;
import com.example.puddingbe.domain.feed.presentation.dto.PostRequestDTO;
import com.example.puddingbe.domain.feed.domain.repository.PostRepository;
import com.example.puddingbe.domain.user.domain.repository.UserRepository;
import com.example.puddingbe.global.detail.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class PostUpdateService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final UserFacade userFacade;


    public void updatePost(Long postId, PostRequestDTO req){
        Long userId = userFacade.getUserId();
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        boolean isAdmin = userRepository.findById(userId).get().getRole().equals("ADMIN");
        // 유저 확인
        if(!isAdmin && !post.getUserId().equals(userId)){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }


        post.update(req.getTitle(), req.getContent());
        postRepository.save(post);
    }
}
