package com.example.puddingbe.domain.awss3.presentation;

import com.example.puddingbe.domain.awss3.presentation.dto.ImageUpdateRequest;
import com.example.puddingbe.domain.awss3.service.S3Service;
import com.example.puddingbe.domain.awss3.service.UserService;
import com.example.puddingbe.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/profile")
public class S3Controller {

    private final S3Service s3Service;
    private final UserService userService;
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/upload")
    public ResponseEntity<String> uploadProfile(
            @RequestParam("file") MultipartFile file,
            @RequestParam("userId") Long userId
    ) {
        String url = s3Service.upload(file, userId);
        return ResponseEntity.ok(url);
    }
    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/profile-image")
    public ResponseEntity<String> updateProfileImage(
            @RequestBody ImageUpdateRequest request
    ) {

        User user = userService.updateProfileImage(
                request.getUserId(),
                request.getImageUrl()
        );

        return ResponseEntity.ok(user.getProfileImageUrl());
    }
}
