package com.example.puddingbe.domain.notice.domain.repository;

import com.example.puddingbe.domain.notice.domain.NoticeUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeUserRepository extends JpaRepository<NoticeUser, Long> {
    List<NoticeUser> Id(Long id);
}
