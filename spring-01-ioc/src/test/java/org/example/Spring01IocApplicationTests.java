package org.example; // 包名要和需要测试的主程序包名一致

import org.example.bean.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest // 测试SpringBoot功能，测试容器功能
public class Spring01IocApplicationTests {

    @Autowired
    User user;
    @Test
    void contextLoads(){

        System.out.println("user = " + user);

    }

}
