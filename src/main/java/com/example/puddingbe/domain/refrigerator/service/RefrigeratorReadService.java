package com.example.puddingbe.domain.refrigerator.service;

import com.example.puddingbe.domain.refrigerator.domain.entity.Ingredient;
import com.example.puddingbe.domain.refrigerator.repository.RefrigeratorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RefrigeratorReadService {

    private final RefrigeratorRepository refrigeratorRepository;

    public List<Ingredient> getRefrigerator() {
        return refrigeratorRepository.findAll();
    }
}