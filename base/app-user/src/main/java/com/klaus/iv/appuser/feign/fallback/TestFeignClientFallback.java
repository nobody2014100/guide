package com.klaus.iv.appuser.feign.fallback;

import com.klaus.iv.appuser.feign.TestFeignClient;
import com.klaus.iv.appuser.vo.AppUserVo;
import com.klaus.iv.appuser.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TestFeignClientFallback implements TestFeignClient {
    @Override
    public ResponseEntity<Boolean> suc() {
        log.info("invoking suc fail");
        return null;
    }

    @Override
    public String hello() {
        log.info("invoking hello fail");
        return null;
    }

    @Override
    public ResponseEntity<UserVo> getUserByID(Long id) {
        log.info("invoking getUserByID fail");
        return ResponseEntity.ok(new UserVo());
    }
}
