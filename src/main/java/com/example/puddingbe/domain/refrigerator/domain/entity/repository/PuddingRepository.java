package com.example.puddingbe.domain.refrigerator.domain.entity.repository;
import com.example.puddingbe.domain.refrigerator.domain.entity.Ingredient;
import com.example.puddingbe.domain.refrigerator.domain.entity.Pudding;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PuddingRepository extends JpaRepository<Pudding, Long> {
    Pudding findByUserId(Long userId);
}
