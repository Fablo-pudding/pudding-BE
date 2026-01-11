package com.example.puddingbe.domain.feed.presentation.dto;

import com.example.puddingbe.domain.feed.domain.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class PostListResponseDTO {
    Long postId;
    Long userId;
    String profileImageUrl;
    String name;
    String title;
    String createdAt;
    Long commentCount;

    public PostListResponseDTO(Post post) {
        this.postId = post.getPostId();
        this.userId = post.getUser().getId();
        this.title = post.getTitle();
        this.createdAt = post.getCreatedAt().toString();
        this.name = post.getUser().getName();
        this.profileImageUrl = post.getUser().getProfileImageUrl();
        this.commentCount = (long) post.getComments().size();
    }

}
