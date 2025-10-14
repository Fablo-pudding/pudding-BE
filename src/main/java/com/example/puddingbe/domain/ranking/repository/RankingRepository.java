package com.example.puddingbe.domain.ranking.repository;

import com.example.puddingbe.domain.ranking.domain.entity.Ranking;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RankingRepository extends JpaRepository<Ranking, Long> {
    List<Ranking> findByUserId(Long userId);
}
