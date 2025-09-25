package com.example.puddingbe.global.inquiry.repository;

import com.example.puddingbe.global.inquiry.domain.entity.Inquiry;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface InquiryRepository extends JpaRepository<Inquiry, Long> {
    List<Inquiry> findByUserId(Long userId);
}
