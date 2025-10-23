package com.example.puddingbe.domain.inquiry.repository;

import com.example.puddingbe.domain.inquiry.domain.Inquiry;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface InquiryRepository extends JpaRepository<Inquiry, Long> {
    List<Inquiry> findByUserId(Long userId);
}
