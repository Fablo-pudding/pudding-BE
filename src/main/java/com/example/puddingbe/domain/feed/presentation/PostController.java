package com.example.puddingbe.domain.feed.presentation;

import com.example.puddingbe.domain.feed.presentation.dto.PostDetailResponseDTO;
import com.example.puddingbe.domain.feed.presentation.dto.PostListResponseDTO;
import com.example.puddingbe.domain.feed.presentation.dto.PostRequestDTO;
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

    // 게시글 생성
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody @Validated PostRequestDTO req) {
        postCreateService.createPost(req);
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
    public void updatePost(@PathVariable Long id, @RequestBody @Validated PostRequestDTO dto){
        postUpdateService.updatePost(id, dto);
    }

    // 게시글 삭제하기
    @DeleteMapping("/delete/{post-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePost(@PathVariable("post-id") Long postId) {
        postDeleteService.delete(postId);
    }
    
}
