package com.example.puddingbe.domain.refrigerator.service;

import com.example.puddingbe.domain.refrigerator.domain.entity.Ingredient;
import com.example.puddingbe.domain.refrigerator.presentation.dto.RefrigeratorResponse;
import com.example.puddingbe.domain.refrigerator.domain.entity.repository.RefrigeratorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RefrigeratorReadService {

    private final RefrigeratorRepository refrigeratorRepository;

    public List<RefrigeratorResponse> getRefrigerator() {
        List<Ingredient> ingredients = refrigeratorRepository.findAll();
        return ingredients.stream()
                .map(RefrigeratorResponse::new)
                .collect(Collectors.toList());
    }
}
