package org.braidner.libme.core.service;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * @author KuznetsovNE/ 05.04.2016.
 */
@Service
@Scope(value = "singleton")
public class AmazonService {

    @Autowired
    private AmazonS3Client amazonS3Client;

    @Bean
    @Scope(value = "singleton")
    public AmazonS3Client init() {
        BasicAWSCredentials awsCredentials = new BasicAWSCredentials("AKIAIHYLB5WPOMZOG7FQ", "c7N5CA3xyFPHwyHI12ZenOMizqKCDiDraUd52v0s");
        AmazonS3Client amazonS3Client = new AmazonS3Client(awsCredentials);
        return amazonS3Client;
    }

    public boolean upload(String key, File file) {
        PutObjectRequest putObjectRequest = new PutObjectRequest("libme-share", key, file);
        putObjectRequest.withCannedAcl(CannedAccessControlList.PublicRead);
        amazonS3Client.putObject(putObjectRequest);
        return true;
    }

    public boolean delete(String key) {
        DeleteObjectRequest deleteObjectRequest = new DeleteObjectRequest("libme-share", key);
        amazonS3Client.deleteObject(deleteObjectRequest);
        return true;
    }
}
