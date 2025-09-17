package com.example.puddingbe.domain.comment.entity;

import com.example.puddingbe.domain.feed.entity.Post;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comment_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false)
    @JsonBackReference
    private Post post;

    // 테스트때는 밑에 Long userId 쓰고 나중에 합칠때 위에 주석 풀고, 밑에 주석처리
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id", nullable = false)
//    private  userId;
    private Long user_id;

    @Column(nullable = false, length = 255)
    private String content;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Builder
    public Comment(Post post,Long userId, String content) {
        this.post = post;
        this.user_id = userId;
        this.content = content;
        this.createdAt = LocalDateTime.now();
    }

    public void update(String content) {
        this.content = content;
    }
}
