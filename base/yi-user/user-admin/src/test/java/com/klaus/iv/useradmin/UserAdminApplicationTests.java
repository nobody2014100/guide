package com.klaus.iv.useradmin;

import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@Slf4j
@SpringBootTest(classes = UserAdminApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles({"local"})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserAdminApplicationTests {



    @Autowired
    private StringEncryptor stringEncryptor;

    @Test
    public void testCrypt() {
        String data = stringEncryptor.encrypt("guide");
        log.info("after encrypt is :{}", data);
        log.info("after decrypt is :{}", stringEncryptor.decrypt(data));
    }
}
