package com.klaus.iv.useradmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication(scanBasePackages = {"com.klaus.iv.commonjpa.config", "com.klaus.iv.useradmin"})
@EnableJpaAuditing(auditorAwareRef = "userAuditor")
@EnableDiscoveryClient
public class UserAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserAdminApplication.class, args);
    }

}
