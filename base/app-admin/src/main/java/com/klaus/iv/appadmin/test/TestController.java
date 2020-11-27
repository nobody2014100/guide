package com.klaus.iv.appadmin.test;


import com.klaus.iv.appadmin.service.TestService;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {


    @Autowired
    private TestService testService;

    @Qualifier("eurekaClient")
    @Autowired
    private EurekaClient discoveryClient;

    public String serviceUrl() {
        InstanceInfo instance = discoveryClient.getNextServerFromEureka("app-user", false);
        return instance.getHomePageUrl();
    }

    @GetMapping
    public ResponseEntity<Boolean> suc() {
        log.info("invoking here...., {}", testService.add(10, 20));
        log.info("serviceUrl is :{}", serviceUrl());
        return ResponseEntity.ok(true);
    }
}
