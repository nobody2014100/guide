package com.klaus.iv.userauthserver.service;

import com.klaus.iv.userapi.userdetails.CusUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface CusUserDetailService extends UserDetailsService {



    CusUserDetails loadUserByEmail(String var1) throws UsernameNotFoundException;
    CusUserDetails loadUserByMobile(String var1) throws UsernameNotFoundException;
}
