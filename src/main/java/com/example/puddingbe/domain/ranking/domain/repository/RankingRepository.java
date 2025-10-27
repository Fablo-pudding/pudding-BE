package com.example.puddingbe.domain.ranking.domain.repository;

import com.example.puddingbe.domain.ranking.domain.Ranking;
import com.example.puddingbe.domain.ranking.presentation.dto.RankingResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RankingRepository extends JpaRepository<Ranking, Long> {
    String rankingQuery = "SELECT * FROM tbl_ranking ORDER BY total_pudding DESC";

    @Query(value = rankingQuery, nativeQuery = true)
    List<RankingResponse> findAllOrderByTotalPuddingDesc();

    Optional<RankingResponse> findByUserId(Long userId);

    Optional<Ranking> findEntityByUserId(Long userId);
}
