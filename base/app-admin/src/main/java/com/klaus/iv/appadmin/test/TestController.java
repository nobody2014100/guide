package com.klaus.iv.appadmin.test;


import com.klaus.iv.appadmin.service.TestService;
import com.klaus.iv.appadmin.vo.UserVo;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {


    @Autowired
    private TestService testService;

//    @Qualifier("eurekaClient")
    @Autowired
    private DiscoveryClient discoveryClient;

    public List<String> serviceUrl() {
        List<ServiceInstance>  instance = discoveryClient.getInstances("app-user");
        List<String> urls = instance.stream().map(i -> i.getUri().getPath()).collect(Collectors.toList());
        return urls;
    }

    @GetMapping(value = "/suc", produces = { "application/json;charset=UTF-8"})
    public ResponseEntity<Boolean> suc() {
        log.info("invoking here suc...., {}", testService.add(10, 20));
        log.info("serviceUrl is :{}", serviceUrl());
        return ResponseEntity.ok(true);
    }

    @RequestMapping(value = "/hello", produces = { "application/json;charset=UTF-8"})
    public String hello() {
        log.info("invoking here hello...., {}", testService.add(10, 20));
        List<ServiceInstance> instances = discoveryClient.getInstances("app-user");
        log.info("service size is :{}", instances.size());
        if (instances.size()> 0) {
            ServiceInstance selectedInstance = instances
                    .get(new Random().nextInt(instances.size()));
            return "Hello World: " + selectedInstance.getServiceId() + ":" + selectedInstance
                    .getHost() + ":" + selectedInstance.getPort();
        } else {
            return "no service";
        }


    }
}
