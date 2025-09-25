package com.example.puddingbe.domain.timer.repository;

import com.example.puddingbe.domain.timer.domain.entity.TimerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface TimerRepository extends JpaRepository<TimerEntity, Long> {
    Optional<TimerEntity> findById(Long id);
}