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

    public void delete(Long postId, UserDetail userDetail){
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        boolean isAdmin = userDetail.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));

        // 관리자 확인, 맞는 아이디인지 확인
        if (!isAdmin && !post.getUserId().equals(userDetail.getUserId())) {
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
