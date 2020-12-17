package com.klaus.iv.commonjpa.config;

import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.jooq.conf.RenderNameStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;

@Configuration
@Slf4j
public class JpaConfig {
    @Bean
    public UserAuditor userAuditor() {
        return new UserAuditor();
    }


    @Autowired
    protected DSLContext dsl;

    @PostConstruct
    private void init() {
        log.info("------------------ invoke JooQHandle .............");
        //		去掉sql中的单引号
        dsl.settings().withRenderNameStyle(RenderNameStyle.AS_IS);
    }

    @Bean
    public PasswordEncoder passwordEncoder()	{
        return new BCryptPasswordEncoder();
    }
}

