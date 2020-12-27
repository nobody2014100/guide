package com.klaus.iv.userauthserver.service.impl;

import com.klaus.iv.userapi.feign.UserClient;
import com.klaus.iv.userapi.userdetails.CusUserDetails;
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
    public CusUserDetails loadUserByEmail(String email) throws UsernameNotFoundException {

        ResponseEntity<CusUserDetails>  userDetailsResponseEntity = userClient.findByEmail(email);

        return userDetailsResponseEntity.getBody();
    }

    @Override
    public CusUserDetails loadUserByMobile(String mobile) throws UsernameNotFoundException {
        ResponseEntity<CusUserDetails> userDetailsResponseEntity = userClient.findByMobile(mobile);
        return userDetailsResponseEntity.getBody();
    }

    @Override
    public CusUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ResponseEntity<CusUserDetails> userDetailsResponseEntity = userClient.findByUsername(username);
        return userDetailsResponseEntity.getBody();
    }
}
