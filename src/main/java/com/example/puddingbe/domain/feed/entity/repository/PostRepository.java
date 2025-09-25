package com.example.puddingbe.domain.feed.entity.repository;

import com.example.puddingbe.domain.feed.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PostRepository extends JpaRepository<Post, Long> {

}
