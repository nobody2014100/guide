package com.klaus.iv.userauthserver.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface CusUserDetailService extends UserDetailsService {



    UserDetails loadUserByEmail(String var1) throws UsernameNotFoundException;
    UserDetails loadUserByMobile(String var1) throws UsernameNotFoundException;
}
