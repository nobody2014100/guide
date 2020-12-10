package com.klaus.iv.useradmin;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication(scanBasePackages = {"com.klaus.iv.commonjpa.config", "com.klaus.iv.useradmin"})
@EnableJpaAuditing(auditorAwareRef = "userAuditor")
@EnableDiscoveryClient
@EnableEncryptableProperties
public class UserAdminApplication {

//    @Autowired
//    private DSLContext dslContext;
    public static void main(String[] args) {
        SpringApplication.run(UserAdminApplication.class, args);

    }

}
