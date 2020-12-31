package com.haizhi.ip.analyseip;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AnalyseIpApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private  IpServicce ipServicce;

    @Test
    public void ip() {
        ipServicce.findIp();
//        ipServicce.findOne();
    }
}
