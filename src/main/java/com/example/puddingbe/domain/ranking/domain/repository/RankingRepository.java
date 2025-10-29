package com.example.puddingbe.domain.ranking.domain.repository;

import com.example.puddingbe.domain.ranking.domain.Ranking;
import com.example.puddingbe.domain.ranking.presentation.dto.RankingResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RankingRepository extends JpaRepository<Ranking, Long> {
    String RANKING_QUERY = """
    SELECT ranking_id AS id, user_id AS userId, total_pudding AS totalPudding
    FROM tbl_ranking
    ORDER BY total_pudding DESC, user_id ASC
    """;

    @Query(value = RANKING_QUERY, nativeQuery = true)
    List<RankingResponse> findAllRankings();

    Optional<Ranking> findRankingByUserId(Long userId);
}
