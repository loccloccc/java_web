package com.example.artwork_management.config;


import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConfig {

    @Value("${cloudinary.cloud.name}")
    private String name;
    @Value("${cloudinary.api.key}")
    private String key;
    @Value("${cloudinary.api.secret}")
    private String secret;

    @Bean
    public Cloudinary cloudinary(){
        return new Cloudinary(
                ObjectUtils.asMap(
                        "cloud_name", name,
                        "api_key", key,
                        "api_secret", secret

                )
        );
    }
}
