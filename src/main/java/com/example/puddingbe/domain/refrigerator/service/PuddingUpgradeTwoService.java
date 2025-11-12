package com.example.puddingbe.domain.refrigerator.service;

import com.example.puddingbe.domain.refrigerator.domain.entity.Pudding;
import com.example.puddingbe.domain.refrigerator.domain.repository.PuddingRepository;
import com.example.puddingbe.domain.refrigerator.presentation.dto.RefrigeratorUpdateTwoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class PuddingUpgradeTwoService {
    private final PuddingRepository puddingRepository;
    public RefrigeratorUpdateTwoResponse upgradePuddingTwo(Long userId){
        Pudding pudding = puddingRepository.findByUserId(userId);

        pudding.usePuddingFor_3();
        pudding.upgradeFor_3();

        puddingRepository.save(pudding);

        return RefrigeratorUpdateTwoResponse.builder()
                .pudding_2(pudding.getPudding_2())
                .pudding_3(pudding.getPudding_3())
                .build();
    }
}
