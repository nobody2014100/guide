package com.klaus.iv.userapi.feign;

import com.klaus.iv.userapi.feign.fallback.UserClientFallback;
import com.klaus.iv.userapi.userdetails.CusUserDetails;
import com.klaus.iv.userapi.vo.UserVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "user-admin", path = "/user-admin",fallback = UserClientFallback.class)
public interface UserClient {

    @GetMapping(value = "/user/{id}",produces = { "application/json;charset=UTF-8"})
    public ResponseEntity<UserVo> findById(@PathVariable("id") Long id) ;

    @GetMapping(value = "/user/email/{id}",produces = { "application/json;charset=UTF-8"})
    public ResponseEntity<CusUserDetails> findByEmail(@PathVariable("email") String email) ;

    @GetMapping(value = "/user/mobile/{mobile}",produces = { "application/json;charset=UTF-8"})
    public ResponseEntity<CusUserDetails> findByMobile(@PathVariable("mobile") String mobile) ;

    @GetMapping(value = "/user/username/{username}",produces = { "application/json;charset=UTF-8"})
    public ResponseEntity<CusUserDetails> findByUsername(@PathVariable("username") String username) ;

}
