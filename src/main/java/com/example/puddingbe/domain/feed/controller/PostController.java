package com.example.puddingbe.domain.feed.controller;

import com.example.puddingbe.domain.feed.entity.dto.PostDetailResponseDTO;
import com.example.puddingbe.domain.feed.entity.dto.PostListResponseDTO;
import com.example.puddingbe.domain.feed.entity.dto.PostRequestDTO;
import com.example.puddingbe.domain.feed.entity.Post;
import com.example.puddingbe.domain.feed.service.PostCreateService;
import com.example.puddingbe.domain.feed.service.PostDeleteService;
import com.example.puddingbe.domain.feed.service.PostReadService;
import com.example.puddingbe.domain.feed.service.PostUpdateService;
import com.example.puddingbe.domain.user.domain.User;
import com.example.puddingbe.domain.user.repository.UserRepository;
import com.example.puddingbe.global.detail.UserDetail;
import com.example.puddingbe.global.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequestMapping("/feed")
@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostCreateService postCreateService;
    private final PostReadService postReadService;
    private final PostUpdateService postUpdateService;
    private final PostDeleteService postDeleteService;
    private final JwtTokenProvider tokenProvider;
    private final UserRepository userRepository;

    // 게시글 생성
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody @Validated PostRequestDTO req, @RequestHeader("Authorization") String token) {
        postCreateService.createPost(req, getUserId(token));
    }

    // 게시글 리스트 가져오기
    @GetMapping("/get-list")
    @ResponseStatus(HttpStatus.OK)
    public List<PostListResponseDTO> getPostAll() {
        return postReadService.getPosts();
    }

    // 게시글 자세한거 가져오기
    @GetMapping("/get-detail/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PostDetailResponseDTO getPostDetail(@PathVariable Long id) {
        return postReadService.getPostDetail(id);
    }

    // 게시글 수정하기
    @PatchMapping("/update/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePost(@PathVariable Long id, @RequestBody @Validated PostRequestDTO dto, @RequestHeader("Authorization") String token){
        postUpdateService.updatePost(id, dto, getUserId(token));
    }

    // 게시글 삭제하기
    @DeleteMapping("/delete/{post-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePost(@PathVariable("post-id") Long postId, @RequestHeader("Authorization") String token) {
        postDeleteService.delete(postId, getUserId(token));
    }

    private Long getUserId(String token) {
        String name;
        try {
            if(token.startsWith("Bearer ")) {
                name = tokenProvider.getNameFromToken(token.substring(7).trim());
            }else {
                name = tokenProvider.getNameFromToken(token.trim());
            }
            return userRepository.findByName(name).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)).getId();
        }catch (ResponseStatusException e) {
            throw e;
        }
        catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "잘못된 토큰");
        }
    }
}
