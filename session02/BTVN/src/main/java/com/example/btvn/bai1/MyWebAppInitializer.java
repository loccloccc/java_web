package com.example.btvn.bai1;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { WebConfig.class };
    }

    // LỖI ở đây — Servlet Mapping bị đặt sai
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };   // ← Chú ý dòng này
    }
}

