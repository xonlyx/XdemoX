package com.example.xdemox.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.common.auth.CredentialsProviderFactory;
import com.aliyun.oss.common.auth.EnvironmentVariableCredentialsProvider;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import com.aliyuncs.exceptions.ClientException;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Component
public class AliOss {
    private String endpoint = "https://oss-cn-shanghai.aliyuncs.com";
    private EnvironmentVariableCredentialsProvider credentialsProvider;
    private String bucketName = "xwebx";
    {
        try {
            credentialsProvider = CredentialsProviderFactory.newEnvironmentVariableCredentialsProvider();
        } catch (ClientException e) {
            throw new RuntimeException(e);
        }
    }




    public String upload(MultipartFile file) throws IOException {

        InputStream inputStream =file.getInputStream();
        String originalFilename= file.getOriginalFilename();
        String filename = UUID.randomUUID().toString()+ originalFilename.substring(originalFilename.lastIndexOf(".") );
        String url = null;

        OSS ossClient = new OSSClientBuilder().build(endpoint, credentialsProvider);
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, filename, inputStream);
        // 创建PutObject请求。
        PutObjectResult result = ossClient.putObject(putObjectRequest);
        url= endpoint.split("//")[0] + "//" +bucketName +"."+endpoint.split("//")[1]+"/"+filename ;
        return url;
    }
}
