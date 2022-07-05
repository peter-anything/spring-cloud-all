package com.macro.cloud.config;

import com.macro.cloud.log.LogInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogAop {
    @Bean
    public LogInfo logInfo() {
        return new LogInfo();
    }
}
