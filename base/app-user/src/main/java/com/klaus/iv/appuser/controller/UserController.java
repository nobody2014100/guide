package com.klaus.iv.appuser.controller;


import com.klaus.iv.appuser.feign.TestFeignClient;
import com.klaus.iv.appuser.vo.AppUserVo;
import com.klaus.iv.appuser.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private TestFeignClient feignClient;

    @GetMapping(produces = { "application/json;charset=UTF-8"} )
    public ResponseEntity<Map> list() {
        log.info("invoking list.....");
        List<AppUserVo> users = new ArrayList<>();
        for (int i =0; i< 10; i++) {
            users.add(generateUser(i));
        }
        Map<String, List<AppUserVo>> map = new HashMap();
        map.put("data", users );
        return ResponseEntity.ok(map);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Map> detail(@PathVariable(name = "id") Integer id) {
        log.info("invoking detail.....");
        Map<String, AppUserVo> map = new HashMap();
        map.put("data", generateUser(id) );
        return ResponseEntity.ok(map);
    }

    public AppUserVo generateUser(Integer id) {
        AppUserVo appUserVo = new AppUserVo();
        appUserVo.setName("klaus"+id);
        appUserVo.setAge(20+id);
        appUserVo.setMobile("1866490993"+id);
        return appUserVo;
    }

    @GetMapping(value = "/suc")
    public ResponseEntity<Boolean> suc() {
        log.info("invoking suc.....");
        return feignClient.suc();
    }


    @GetMapping(value = "/hello")
    public ResponseEntity<String> hello() {
        log.info("invoking hello.....");
        return ResponseEntity.ok(feignClient.hello());
    }



    @GetMapping(value = "/find/{id}")
    public ResponseEntity<UserVo> findByID(@PathVariable("id") Long id) {
        log.info("invoking hello.....");
        return feignClient.getUserByID(id);
    }



}
