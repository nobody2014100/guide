package com.klaus.iv.appuser.controller;


import com.klaus.iv.appuser.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
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

    @GetMapping(produces = { "application/json;charset=UTF-8"} )
    public ResponseEntity<Map> list() {
        log.info("invoking list.....");
        List<UserVo> users = new ArrayList<>();
        for (int i =0; i< 10; i++) {
            users.add(generateUser(i));
        }
        Map<String, List<UserVo>> map = new HashMap();
        map.put("data", users );
        return ResponseEntity.ok(map);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Map> detail(@PathVariable(name = "id") Integer id) {
        log.info("invoking detail.....");
        Map<String, UserVo> map = new HashMap();
        map.put("data", generateUser(id) );
        return ResponseEntity.ok(map);
    }

    public UserVo generateUser(Integer id) {
        UserVo  userVo = new UserVo();
        userVo.setName("klaus"+id);
        userVo.setAge(20+id);
        userVo.setMobile("1866490993"+id);
        return userVo;
    }

}
