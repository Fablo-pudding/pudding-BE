package com.example.puddingbe.domain.feed.controller;

import com.example.puddingbe.domain.feed.entity.dto.PostRequestDTO;
import com.example.puddingbe.domain.feed.entity.Post;
import com.example.puddingbe.domain.feed.service.PostCreateService;
import com.example.puddingbe.domain.feed.service.PostDeleteService;
import com.example.puddingbe.domain.feed.service.PostReadService;
import com.example.puddingbe.domain.feed.service.PostUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody @Validated PostRequestDTO req) {
        postCreateService.createPost(req);
    }

    @GetMapping
    public List<Post> getPostAll() {
        return postReadService.getPostList();
    }

    @GetMapping("/{id}")
    public Post getPostDetail(@PathVariable Long id) {
        return postReadService.getPostDetail(id);
    }

    @PatchMapping("/{id}")
    public void updatePost(@PathVariable Long id, @RequestBody @Validated PostRequestDTO dto){
        postUpdateService.updatePost(id, dto);
    }

    @DeleteMapping("/{postId}/{userId}")
    public void deletePost(@PathVariable Long postId, @PathVariable Long userId) {
        postDeleteService.delete(postId, userId);
    }
}
