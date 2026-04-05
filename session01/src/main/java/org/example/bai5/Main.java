package org.example.bai5;

import org.example.bai5.config.AppConfig;
import org.example.bai5.model.SystemConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    static void main() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        SystemConfig config  = context.getBean(SystemConfig.class);
        System.out.println(config.getBranchName());
        System.out.println(config.getOpeningHour());
    }
}
