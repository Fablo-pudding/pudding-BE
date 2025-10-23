package com.example.puddingbe.domain.refrigerator.controller;

import com.example.puddingbe.domain.refrigerator.dto.RefrigeratorResponse;
import com.example.puddingbe.domain.refrigerator.service.RefrigeratorReadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/storage")
@RequiredArgsConstructor
public class RefrigeratorController {

    private final RefrigeratorReadService refrigeratorReadService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<RefrigeratorResponse>> getRefrigerator() {
        List<RefrigeratorResponse> response = refrigeratorReadService.getRefrigerator();
        return ResponseEntity.ok(response);
    }
}
