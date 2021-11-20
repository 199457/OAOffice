package com.wei.server;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class ServerApplicationTests {

    @Test
    void contextLoads() {
        BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
        String encode = pe.encode("12321");
        System.out.println(encode);
        // 加密匹配
        boolean matches = pe.matches("12321", encode);
        System.out.println(matches);
    }

}
