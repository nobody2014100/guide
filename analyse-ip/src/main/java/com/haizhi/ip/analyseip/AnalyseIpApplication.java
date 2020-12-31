package com.haizhi.ip.analyseip;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@Slf4j
public class AnalyseIpApplication {


    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(AnalyseIpApplication.class, args);
        IpServicce ipServicce = (IpServicce)applicationContext.getBean("ipServicce");
        ipServicce.findIp();

    }


}
