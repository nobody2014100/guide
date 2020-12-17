package com.klaus.iv.userauthserver.controller;

import com.klaus.iv.commonweb.R;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {


    public ResponseEntity<R> login() {
        return R.suc(true);
    }

}
