package com.klaus.iv.appadmin.service.impl;

import com.klaus.iv.appadmin.service.TestService;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {


    @Override
    public int add(int x, int y) {
        return x+y;
    }
}
