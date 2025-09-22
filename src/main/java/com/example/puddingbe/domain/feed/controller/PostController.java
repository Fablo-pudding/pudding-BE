package com.example.puddingbe.domain.feed.controller;

import com.example.puddingbe.domain.feed.entity.dto.PostDetailResponseDTO;
import com.example.puddingbe.domain.feed.entity.dto.PostListResponseDTO;
import com.example.puddingbe.domain.feed.entity.dto.PostRequestDTO;
import com.example.puddingbe.domain.feed.entity.Post;
import com.example.puddingbe.domain.feed.service.PostCreateService;
import com.example.puddingbe.domain.feed.service.PostDeleteService;
import com.example.puddingbe.domain.feed.service.PostReadService;
import com.example.puddingbe.domain.feed.service.PostUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/feed")
@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostCreateService postCreateService;
    private final PostReadService postReadService;
    private final PostUpdateService postUpdateService;
    private final PostDeleteService postDeleteService;

    // 게시글 생성
    @PostMapping("/create")
    public ResponseEntity<Void> create(@RequestBody @Validated PostRequestDTO req) {
        postCreateService.createPost(req);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    // 게시글 리스트 가져오기
    @GetMapping("/get-list")
    public ResponseEntity<List<PostListResponseDTO>> getPostAll() {
        return ResponseEntity.status(HttpStatus.OK).body(postReadService.getPosts());
    }

    // 게시글 자세한거 가져오기
    @GetMapping("/get-detail/{id}")
    public ResponseEntity<PostDetailResponseDTO> getPostDetail(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(postReadService.getPostDetail(id));
    }

    // 게시글 수정하기
    @PatchMapping("/update/{id}")
    public ResponseEntity<Void> updatePost(@PathVariable Long id, @RequestBody @Validated PostRequestDTO dto){
        postUpdateService.updatePost(id, dto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    // 게시글 삭제하기 - 일단 임시로 path로 userId가져옴
    @DeleteMapping("/delete/{post-id}/{user-id}")
    public ResponseEntity<Void> deletePost(@PathVariable("post-id") Long postId, @PathVariable("user-id") Long userId) {
        postDeleteService.delete(postId, userId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
