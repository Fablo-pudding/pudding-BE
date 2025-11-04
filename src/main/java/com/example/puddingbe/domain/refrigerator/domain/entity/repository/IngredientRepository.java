package com.example.puddingbe.domain.refrigerator.domain.entity.repository;

import com.example.puddingbe.domain.refrigerator.domain.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface IngredientRepository extends JpaRepository<Ingredient , Long> {
    List<Ingredient> findByUserId(Long userId);
}
