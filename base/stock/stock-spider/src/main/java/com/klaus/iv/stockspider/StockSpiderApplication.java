package com.klaus.iv.stockspider;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.oas.annotations.EnableOpenApi;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@SpringBootApplication
@RestController
@Slf4j
@EnableDiscoveryClient
@EnableOpenApi
@EnableFeignClients(basePackages = {"com.klaus.iv.stockapi.feign"})
public class StockSpiderApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockSpiderApplication.class, args);
    }

    @GetMapping("/status/{code}")
    public ResponseEntity status(HttpServletRequest request, @PathVariable(name = "code") Boolean code) {

        log.info("info is : {}, {}, code is:{}", request.getRequestURI(), request.getRequestURL(), code);
        HashMap<String, String> data = new HashMap<>();
        data.put("code", String.valueOf(code));
        data.put("data", "正常");
        return ResponseEntity.ok(data);
    }
}
