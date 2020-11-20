package com.klaus.iv.appregister;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class AppRegisterApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppRegisterApplication.class, args);
    }

}
