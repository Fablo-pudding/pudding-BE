package com.example.puddingbe.domain.notice.domain.repository;

import com.example.puddingbe.domain.notice.domain.NoticeUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticeUserRepository extends JpaRepository<NoticeUser, Long> {

}
