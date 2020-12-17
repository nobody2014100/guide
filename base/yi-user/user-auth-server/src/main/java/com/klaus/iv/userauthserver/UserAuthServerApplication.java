package com.klaus.iv.userauthserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = {"com.klaus.iv.userapi.feign"})
public class UserAuthServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserAuthServerApplication.class, args);
    }

}
