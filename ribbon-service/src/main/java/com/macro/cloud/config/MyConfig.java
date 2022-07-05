package com.macro.cloud.config;

import com.macro.cloud.service.DemoService;
import com.macro.cloud.service.FooService;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class MyConfig {
    @Bean
    public DemoService demoService(final ObjectProvider<List<FooService>> fooServices) {
        fooServices.ifAvailable(mFooServices -> {
                mFooServices.get(0).sayHello();
        });
        return new DemoService();
    }
}
