package com.example.puddingbe.domain.inquiry.domain.repository;

import com.example.puddingbe.domain.inquiry.domain.Inquiry;
import com.example.puddingbe.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface InquiryRepository extends JpaRepository<Inquiry, Long> {
    List<Inquiry> findByUser(User user);
}
