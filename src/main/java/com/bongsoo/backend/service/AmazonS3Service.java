package com.bongsoo.backend.service;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AmazonS3Service {                      // 1. 채팅 기록 백업(후순위)      2. 데이터(파일, 이미지) 업로드 메소드 구현(개발 필요)

    private final AmazonS3 amazonS3Client;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    public String urlTest(String path){
        return amazonS3Client.getUrl(bucket,path).toString();
    }       // Just Test

    //public void uploadChatFile(String name)                                           // 1. 채팅 백업하기
    public List<String> downloadChatFile(String name) {                                 // 2. 백업된 기록을 가지고올 경우
        List<String> list = new ArrayList<>();

        try {
            // 백업 불러오기
            S3Object s3Object = amazonS3Client.getObject(bucket, name);
            // try-with-resources 방식으로 모든 Stream 은 try-with-resources 문을 종료하면 자동으로 close()된다.
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(s3Object.getObjectContent(), StandardCharsets.UTF_8))) {
                // txt to List
                list = reader.lines().collect(Collectors.toList());
            }
        } catch (AmazonClientException | IOException e) {
            e.printStackTrace();
        }

        return list;
    }

    public void uploadFile(String fileName, File file){                                 // 3. 데이터(파일, 이미지) 업로드
        amazonS3Client.putObject(new PutObjectRequest(bucket,fileName, file).withCannedAcl(CannedAccessControlList.PublicRead)); // public 권한으로 업로드 됨
    }

    public void delete(String fileName){                                                // 4. 버킷에 담긴 데이터 삭제(공용)
        amazonS3Client.deleteObject(bucket,fileName);
    }

}
