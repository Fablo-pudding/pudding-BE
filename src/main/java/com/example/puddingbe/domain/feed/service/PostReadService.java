package com.example.puddingbe.domain.feed.service;

import com.example.puddingbe.domain.awss3.exception.UserNotFound;
import com.example.puddingbe.domain.comment.domain.Comment;
import com.example.puddingbe.domain.comment.presentation.dto.CommentResponseDTO;
import com.example.puddingbe.domain.feed.domain.Post;
import com.example.puddingbe.domain.feed.exception.PostNotFoundExcpetion;
import com.example.puddingbe.domain.feed.presentation.dto.PostDetailResponseDTO;
import com.example.puddingbe.domain.feed.presentation.dto.PostListResponseDTO;
import com.example.puddingbe.domain.feed.domain.repository.PostRepository;
import com.example.puddingbe.domain.user.domain.User;
import com.example.puddingbe.domain.user.domain.repository.UserRepository;
import com.example.puddingbe.global.detail.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostReadService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    //모두 가져오기, 자세한 내용(하나만) 가져오기
    public List<PostListResponseDTO> getPosts() {
        List<Post> posts = postRepository.findAll();

        //List<Post>타입을 List<PostResponse>타입으로 변경
        return posts.stream().map(post -> {
            User user = userRepository.findById(post.getUserId()).orElseThrow(() -> UserNotFound.EXCEPTION);

            return new PostListResponseDTO(
                    post.getId(),
                    user.getProfileImageUrl(),
                    post.getTitle(),
                    user.getName(),
                    post.getCreatedAt(),
                    post.getComments().size()
            );
        }).collect(Collectors.toList());
    }

    public PostDetailResponseDTO getPostDetail(Long postId){
        Post post = postRepository.findById(postId).orElseThrow(() -> PostNotFoundExcpetion.EXCPETION);
        User postUser = userRepository.findById(post.getUserId()).orElseThrow(() -> UserNotFound.EXCEPTION);

        try {
            return new PostDetailResponseDTO(
                    post.getId(),
                    post.getUserId(),
                    userRepository.findById(post.getUserId()).get().getName(),
                    postUser.getProfileImageUrl(),
                    post.getTitle(),
                    post.getContent(),
                    post.getCreatedAt(),
                    post.getComments().stream().map( comment -> {
                        User user = userRepository.findById(comment.getUserId()).get();

                        return new CommentResponseDTO(
                                comment.getCommentId(),
                                comment.getUserId(),
                                user.getName(),
                                user.getProfileImageUrl(),
                                comment.getContent()
                        );
                            }
                    ).toList(),
                    post.getComments().stream().count()
            );
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}