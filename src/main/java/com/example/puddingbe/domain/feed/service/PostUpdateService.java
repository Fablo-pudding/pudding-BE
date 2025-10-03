package com.example.puddingbe.domain.feed.service;

import com.example.puddingbe.domain.feed.entity.Post;
import com.example.puddingbe.domain.feed.entity.dto.PostRequestDTO;
import com.example.puddingbe.domain.feed.entity.repository.PostRepository;
import com.example.puddingbe.domain.user.repository.UserRepository;
import com.example.puddingbe.global.detail.UserDetail;
import com.example.puddingbe.global.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class PostUpdateService {
    private final PostRepository postRepository;


    public void updatePost(Long postId, PostRequestDTO req, UserDetail userDetail){
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        boolean isAdmin = userDetail.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("RULE_ADMIN"));

        // 유저 확인
        if(!isAdmin && !post.getUserId().equals(userDetail.getUserId())){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }

        post.update(req.getTitle(), req.getContent());
        postRepository.save(post);
    }
}
