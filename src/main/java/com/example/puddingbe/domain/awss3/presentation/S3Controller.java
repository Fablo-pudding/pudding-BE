package com.example.puddingbe.domain.awss3.presentation;

import com.example.puddingbe.domain.awss3.service.S3Service;
import com.example.puddingbe.domain.awss3.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/profile")
@RequiredArgsConstructor
public class S3Controller {

    private final S3Service s3Service;
    private final UserService userService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadProfile(
            @RequestParam("file") MultipartFile file,   // 🔥 key = file
            @RequestParam("userId") Long userId         // 🔥 key = userId
    ) {
        // S3 업로드
        String url = s3Service.upload(file, userId);

        // DB 업데이트
        userService.updateProfileUrl(userId, url);

        return ResponseEntity.ok(url);
    }
}