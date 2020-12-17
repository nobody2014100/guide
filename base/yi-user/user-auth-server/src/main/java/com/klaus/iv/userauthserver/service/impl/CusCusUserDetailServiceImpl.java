package com.klaus.iv.userauthserver.service.impl;

import com.klaus.iv.userapi.feign.UserClient;
import com.klaus.iv.userapi.vo.UserVo;
import com.klaus.iv.userauthserver.service.CusUserDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CusCusUserDetailServiceImpl implements CusUserDetailService {

    @Autowired
    private UserClient userClient;

    @Override
    public UserDetails loadUserByEmail(String email) throws UsernameNotFoundException {

        ResponseEntity<UserVo>  userVo = userClient.findByEmail(email);

        return null;
    }

    @Override
    public UserDetails loadUserByMobile(String mobile) throws UsernameNotFoundException {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ResponseEntity<UserVo> userVo = userClient.findByUsername(username);
        return null;
    }
}
