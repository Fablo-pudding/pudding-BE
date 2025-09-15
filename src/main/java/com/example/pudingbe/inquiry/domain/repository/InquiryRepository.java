package com.example.pudingbe.inquiry.domain.repository;

import com.example.pudingbe.inquiry.domain.entity.Inquiry;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface InquiryRepository extends JpaRepository<Inquiry, Long> {
    List<Inquiry> findByUserId(Long userId);
}
