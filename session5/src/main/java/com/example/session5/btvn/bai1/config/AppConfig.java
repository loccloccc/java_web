package com.example.session5.btvn.bai1.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.example.session5.btvn")
public class AppConfig {
    // 1 : doc file view
    @Bean
    public SpringResourceTemplateResolver resolver(){
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        // tien to , hau to
        templateResolver.setPrefix("/WEB-INF/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setCharacterEncoding("UTF-8");
        return templateResolver;
    }

    @Bean
    public SpringTemplateEngine engine(){
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(resolver());
        return templateEngine;
    }

    @Bean
    public ThymeleafViewResolver viewResolver(){
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(engine());
        resolver.setCharacterEncoding("UTF-8");
        return resolver;
    }
}

// 2 loi sai tien to va hau to:
// - "/WEB-INF/views" --> "/WEB-INF/templates/"
// .jsp --> .html
