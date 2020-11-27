package com.klaus.iv.appuser.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@FeignClient
public interface TestFeignClient {

    @GetMapping("/test")
    public ResponseEntity<Map> suc() ;
}
