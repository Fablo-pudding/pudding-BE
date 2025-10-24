package com.example.puddingbe.domain.refrigerator.domain.entity.repository;
import com.example.puddingbe.domain.refrigerator.domain.entity.Pudding;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PuddingRepository extends JpaRepository<Pudding, Long> {
    List<Pudding> findByUserId(Long userId);
}
