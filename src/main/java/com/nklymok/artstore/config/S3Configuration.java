package com.nklymok.artstore.config;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class S3Configuration {

    @Value("${s3.region}")
    private String region;

    @Bean
    public AmazonS3 getAmazonS3Client() {
        ProfileCredentialsProvider provider = new ProfileCredentialsProvider();
        System.out.println(provider.getCredentials().getAWSSecretKey());
        System.out.println(provider.getCredentials().getAWSAccessKeyId());
        return AmazonS3ClientBuilder
                .standard()
                .withRegion(Regions.fromName(region))
                .withCredentials(provider)
                .build();
    }

}