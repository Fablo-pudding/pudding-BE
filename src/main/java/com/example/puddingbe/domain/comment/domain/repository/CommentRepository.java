package com.example.puddingbe.domain.comment.domain.repository;

import com.example.puddingbe.domain.comment.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
