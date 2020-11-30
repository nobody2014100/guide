package com.klaus.iv.appuser.feign;

import com.klaus.iv.appuser.feign.fallback.TestFeignClientFallback;
import com.klaus.iv.appuser.vo.AppUserVo;
import com.klaus.iv.appuser.vo.UserVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "app-admin", path = "/app-admin", fallback = TestFeignClientFallback.class)
public interface TestFeignClient {

    @GetMapping(path = "/test/suc", produces = { "application/json;charset=UTF-8"})
    public ResponseEntity<Boolean> suc() ;

    @GetMapping(value = "/test/hello", produces = { "application/json;charset=UTF-8"})
    public String hello() ;


    @GetMapping(value = "/user/{id}", produces = { "application/json;charset=UTF-8"})
    public ResponseEntity<UserVo> getUserByID(@PathVariable(name = "id") Long id) ;



}
