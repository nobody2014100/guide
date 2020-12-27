package com.klaus.iv.userauthserver.controller;

import com.klaus.iv.commonweb.R;
import com.klaus.iv.userapi.constents.LoginType;
import com.klaus.iv.userapi.dto.LoginDto;
import com.klaus.iv.userapi.userdetails.CusUserDetails;
import com.klaus.iv.userauthserver.service.CusUserDetailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "Auth module")
@Slf4j
public class AuthController {


    @Autowired
    private CusUserDetailService cusUserDetailService;




    @GetMapping
    @ApiOperation(value = "login")
    public ResponseEntity<R> login(@RequestBody LoginDto loginDto) {

        log.info("loginDto is :{}" , loginDto);
        CusUserDetails userDetails ;
        switch (LoginType.valueOf(loginDto.getLoginType())) {
            case COMMON: {
                userDetails = (CusUserDetails) cusUserDetailService.loadUserByUsername(loginDto.getUsername());
                break;
            }
            case EMAIL: {
                userDetails = cusUserDetailService.loadUserByEmail(loginDto.getEmail());
                break;
            }
            case MOBILE: {
                userDetails = cusUserDetailService.loadUserByMobile(loginDto.getMobile());
                break;
            }
            default: break;
        }


        return R.suc(true);
    }

}
