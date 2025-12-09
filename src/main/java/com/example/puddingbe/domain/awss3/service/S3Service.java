package com.example.puddingbe.domain.awss3.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.example.puddingbe.domain.awss3.exception.EmptyFile;
import com.example.puddingbe.domain.awss3.exception.NullFile;
import com.example.puddingbe.domain.awss3.exception.OnlyCanImg;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class S3Service {

    private final AmazonS3 amazonS3;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    public String upload(MultipartFile file, Long userId) {

        if (file.isEmpty()) {
            throw new EmptyFile();
        }
        if (file == null){
            throw new NullFile();
        }

        String contentType = file.getContentType();
        if (contentType == null || !contentType.startsWith("image")) {
            throw new OnlyCanImg();
        }

        String originalName = file.getOriginalFilename();
        String key = "profile/" + userId + "/" + UUID.randomUUID() + "_" + originalName;

        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentType(file.getContentType());
        metadata.setContentLength(file.getSize());

        try {
            amazonS3.putObject(
                    new PutObjectRequest(bucket, key, file.getInputStream(), metadata)
            );
        } catch (IOException e) {
            throw new RuntimeException("S3 업로드 실패", e);
        }

        return amazonS3.getUrl(bucket, key).toString();
    }
}
