package com.example.session04.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

// đánh dấu là lớp cấu hình
@Configuration
// Bật chế độ web mvc
@EnableWebMvc
// Quét các bean đang cần được khởi tạo
@ComponentScan(basePackages = "com.example.session04")
public class AppConfig {

    // Cấu hình bean ViewResolver để đọc được view
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver =
                new InternalResourceViewResolver();
        // cấu hình tiến tố
        viewResolver.setPrefix("/WEB-INF/views/");
        // cấu hình hậu tố
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

}