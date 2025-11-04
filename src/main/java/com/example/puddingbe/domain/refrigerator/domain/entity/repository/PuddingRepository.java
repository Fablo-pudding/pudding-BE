package com.example.puddingbe.domain.refrigerator.domain.entity.repository;
import com.example.puddingbe.domain.refrigerator.domain.entity.Pudding;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PuddingRepository extends JpaRepository<Pudding, Long> {
    Optional<Pudding> findByUserId(Long userId);
}
