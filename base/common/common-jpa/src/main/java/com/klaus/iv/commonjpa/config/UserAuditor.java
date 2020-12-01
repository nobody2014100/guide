package com.klaus.iv.commonjpa.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;


@Slf4j
public class UserAuditor implements AuditorAware<Long> {

    /**
     * 获取当前创建或修改的用户
     * @return
     */
    @Override
    public Optional<Long> getCurrentAuditor() {
//        UserDetails user;
//        try {
//            user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//            return Optional.ofNullable(user.getUsername());
//        }catch (Exception e){
//            return Optional.empty();
//        }
        return Optional.of(1L);
    }
}