package com.wql;

import com.wql.domain.LoginPojo;
import com.wql.service.imp.LoginServiceImp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TaskOneApplicationTests {
    @Autowired
    private LoginServiceImp loginServiceImp;
    @Test
    void contextLoads() {
        LoginPojo loginPojo=new LoginPojo();
        loginPojo.setUser("nh");
        loginPojo.setPassword("nh6");
        LoginPojo byid_login = loginServiceImp.getByid_Login(loginPojo);
        System.out.println(byid_login);
    }

}
