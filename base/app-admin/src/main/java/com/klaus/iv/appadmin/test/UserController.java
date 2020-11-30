package com.klaus.iv.appadmin.test;


import com.klaus.iv.appadmin.service.TestService;
import com.klaus.iv.appadmin.vo.AddressVo;
import com.klaus.iv.appadmin.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {



    @GetMapping(value = "/{id}", produces = { "application/json;charset=UTF-8"})
    public ResponseEntity<UserVo> findByID(@PathVariable(name = "id") Long id) {
        log.info("invoking findByID .....{}", id);
        return ResponseEntity.ok(generateUser(id));
    }

    private UserVo generateUser(Long id) {
        String base = "klaus";
        UserVo userVo = new UserVo();
        userVo.setUsername(base+id);
        userVo.setAvatar(base+id);
        userVo.setMobile(base+id);
        userVo.setPassword(base+id);
        userVo.setOpenID(base+id);
        userVo.setBirthDay(new Date());
        for (Long i = id; i<= id+3; i++) {
            AddressVo addressVo = new AddressVo();
            addressVo.setDetail(base+i);
            addressVo.setDistrictCode(base+i);
            addressVo.setStreetCode(base+i);
            addressVo.setCityCode(base+i);
            addressVo.setProvenceCode(base+i);
            addressVo.setCountryCode(base+i);
            addressVo.setType(i%2==0?AddressVo.AddressType.COMPANY: AddressVo.AddressType.HOME);
            userVo.getAddressVos().add(addressVo);
        }
        return userVo;
    }

}
