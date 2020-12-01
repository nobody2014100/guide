package com.klaus.iv.commonjpa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JpaConfig {
    @Bean
    public UserAuditor userAuditor() {
        return new UserAuditor();
    }
}

