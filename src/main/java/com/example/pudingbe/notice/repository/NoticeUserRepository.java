package com.example.pudingbe.notice.repository;

import com.example.pudingbe.notice.domain.NoticeUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeUserRepository extends JpaRepository<NoticeUser, Long> { }