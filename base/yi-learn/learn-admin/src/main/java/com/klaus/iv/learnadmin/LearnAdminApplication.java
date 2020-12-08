package com.klaus.iv.learnadmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class LearnAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnAdminApplication.class, args);
    }

}
