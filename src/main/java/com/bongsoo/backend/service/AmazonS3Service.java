package com.bongsoo.backend.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AmazonS3Service {

    private final AmazonS3 amazonS3Client;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    public void upload(String fileName, File file){
        amazonS3Client.putObject(new PutObjectRequest(bucket,fileName, file).withCannedAcl(CannedAccessControlList.PublicRead)); // public 권한으로 업로드 됨
    }

    public String urlTest(String path){
        return amazonS3Client.getUrl(bucket,path).toString();
    }

    public List<String> getMessageBackUp(String name) throws IOException {
        S3Object s3Object = amazonS3Client.getObject(bucket,name);
        InputStream inputStream = s3Object.getObjectContent();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream,"UTF-8");
        BufferedReader reader = new BufferedReader(inputStreamReader);
        List<String> list = new ArrayList<>();
        String line;
        while((line = reader.readLine())!=null){
            list.add(line);
        }
        reader.close();
        inputStreamReader.close();
        inputStream.close();
        return list;
    }

    public void delete(String fileName){
        amazonS3Client.deleteObject(bucket,fileName);
    }

}
