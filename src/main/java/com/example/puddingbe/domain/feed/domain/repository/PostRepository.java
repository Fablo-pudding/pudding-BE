package com.example.puddingbe.domain.feed.domain.repository;

import com.example.puddingbe.domain.feed.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PostRepository extends JpaRepository<Post, Long> {

}
