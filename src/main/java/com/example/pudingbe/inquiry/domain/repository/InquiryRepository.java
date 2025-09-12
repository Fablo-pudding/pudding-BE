package com.example.pudingbe.inquiry.domain.repository;

import com.example.pudingbe.inquiry.domain.entity.Inquiry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InquiryRepository extends JpaRepository<Inquiry, Long> {

}
