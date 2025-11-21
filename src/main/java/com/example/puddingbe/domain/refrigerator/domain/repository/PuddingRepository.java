package com.example.puddingbe.domain.refrigerator.domain.repository;
import com.example.puddingbe.domain.refrigerator.domain.entity.Pudding;
import com.example.puddingbe.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface PuddingRepository extends JpaRepository<Pudding, Long> {
    Pudding findByUserId(Long userId);
    Pudding findByUser(User user);

    @Query(value = "SELECT * FROM tbl_pudding ORDER BY pudding_3 DESC ", nativeQuery = true)
    List<Pudding> findAllByOrderByPudding3Desc();
}
