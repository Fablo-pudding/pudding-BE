package com.example.puddingbe.domain.refrigerator.service;

import com.example.puddingbe.domain.refrigerator.domain.entity.Pudding;
import com.example.puddingbe.domain.refrigerator.domain.repository.PuddingRepository;
import com.example.puddingbe.domain.refrigerator.presentation.dto.RefrigeratorUpdateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PuddingUpgradeOneService {
    private final PuddingRepository puddingRepository;

    public RefrigeratorUpdateResponse upgradePudding(Long userId){
        Pudding pudding = puddingRepository.findByUserId(userId);

        pudding.usePuddingFor_2();

        pudding.upgradeFor_2();

        puddingRepository.save(pudding);

        return RefrigeratorUpdateResponse.builder()
                .pudding_1(pudding.getPudding_1())
                .pudding_2(pudding.getPudding_2())
                .build();
    }
}
