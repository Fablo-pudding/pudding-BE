package com.example.puddingbe.domain.refrigerator.domain.entity.repository;

import com.example.puddingbe.domain.refrigerator.domain.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient , Long> {
    Ingredient findByUserId(Long userId);
}
