package com.example.puddingbe.domain.timer.domain.repository;

import com.example.puddingbe.domain.timer.domain.TimerEntity;
import com.example.puddingbe.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface TimerRepository extends JpaRepository<TimerEntity, Long> {
    Optional<TimerEntity> findByUser(User user);

    boolean existsByUser(User user);
}