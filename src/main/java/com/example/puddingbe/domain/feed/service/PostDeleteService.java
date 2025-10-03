package com.example.puddingbe.domain.feed.service;

import com.example.puddingbe.domain.feed.entity.Post;
import com.example.puddingbe.domain.feed.entity.repository.PostRepository;
import com.example.puddingbe.domain.user.domain.User;
import com.example.puddingbe.domain.user.repository.UserRepository;
import com.example.puddingbe.global.detail.UserDetail;
import com.example.puddingbe.global.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class PostDeleteService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public void delete(Long postId, Long userId){
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        boolean isAdmin = userRepository.findById(userId).get().getRole().equals("ADMIN");

        // 관리자 확인, 맞는 아이디인지 확인
        if (!isAdmin && !post.getUserId().equals(userId)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }

        try
        {
            postRepository.delete(post);

        }catch (Exception e) {
            throw  new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
