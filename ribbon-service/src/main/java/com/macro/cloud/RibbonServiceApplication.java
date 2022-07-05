package com.macro.cloud;

import com.macro.cloud.service.DemoService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;

@EnableDiscoveryClient
@SpringBootApplication
public class RibbonServiceApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(RibbonServiceApplication.class, args);
        DemoService demoService = applicationContext.getBean(DemoService.class);
        for (String name: applicationContext.getBeanDefinitionNames()) {
            System.out.println(name);
        }
        System.out.println(demoService);
    }

}
