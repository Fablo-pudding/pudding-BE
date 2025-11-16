package com.example.puddingbe.domain.refrigerator.presentation;

import com.example.puddingbe.domain.refrigerator.domain.entity.Ingredient;
import com.example.puddingbe.domain.refrigerator.presentation.dto.*;
import com.example.puddingbe.domain.refrigerator.service.*;
import com.example.puddingbe.global.detail.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/storage")
@RequiredArgsConstructor
public class RefrigeratorController {

    private final RefrigeratorReadService refrigeratorReadService;
    private final RefrigeratorCreateService refrigeratorCreateService;
    private final PuddingUpgradeOneService puddingUpgradeService;
    private final PuddingUpgradeTwoService puddingUpgradeTwoService;
    private final AddMilkService addMilkService;
    private final AddSugarService addSugarService;
    private final AddEggService addEggService;
    private final UserFacade userFacade;

    @GetMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public RefrigeratorResponse getRefrigerator(@PathVariable Long userId) {
        return refrigeratorReadService.getRefrigerator(userId);
    }
    @PostMapping("/make")
    @ResponseStatus(HttpStatus.CREATED)
    public RefrigeratorCreateResponse createPudding() {
        Long userId = userFacade.getUserId(); // <-- 현재 로그인한 유저로 자동으로 해줌 id안적어도됨
        return refrigeratorCreateService.createPudding(userId);
    }
    @PostMapping("/upgrade-one")
    @ResponseStatus(HttpStatus.CREATED)
    public RefrigeratorUpdateResponse upgradePudding() {
        Long userId = userFacade.getUserId();
        return puddingUpgradeService.upgradePudding(userId);
    }
    @PostMapping("/upgrade-two")
    @ResponseStatus(HttpStatus.CREATED)
    public RefrigeratorUpdateTwoResponse upgradePuddingTwo() {
        Long userId = userFacade.getUserId();
        return puddingUpgradeTwoService.upgradePuddingTwo(userId);
    }

    @PostMapping("/get-milk")
    @ResponseStatus(HttpStatus.OK)
    public IngredientAddResponse getMilk() {
        Long userId = userFacade.getUserId();
        return addMilkService.addSomeMilk(userId);
    }

    @PostMapping("/get-egg")
    @ResponseStatus(HttpStatus.OK)
    public IngredientAddResponse getEgg() {
        Long userId = userFacade.getUserId();
        return addEggService.addSomeEgg(userId);
    }

    @PostMapping("/get-sugar")
    @ResponseStatus(HttpStatus.OK)
    public IngredientAddResponse getSugar() {
        Long userId = userFacade.getUserId();
        return addSugarService.addSomeSugar(userId);
    }

}
