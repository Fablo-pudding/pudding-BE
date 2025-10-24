package com.example.puddingbe.domain.refrigerator.presentation;

import com.example.puddingbe.domain.refrigerator.presentation.dto.RefrigeratorResponse;
import com.example.puddingbe.domain.refrigerator.service.RefrigeratorReadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/storage")
@RequiredArgsConstructor
public class RefrigeratorController {

    private final RefrigeratorReadService refrigeratorReadService;

    @GetMapping("/{user-Id}")
    @ResponseStatus(HttpStatus.OK)
    public RefrigeratorResponse getRefrigerator(@PathVariable Long userId) {
        return refrigeratorReadService.getRefrigerator(userId);
    }
}
