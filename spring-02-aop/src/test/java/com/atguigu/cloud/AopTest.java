package com.atguigu.cloud;

import com.atguigu.cloud.calculator.MathCalculator;
import com.atguigu.cloud.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AopTest {

    @Autowired // 容器中是他的代理对象
    private MathCalculator mathCalculator;
    @Autowired
    private UserService userService;
    @Test
    void test01(){

        System.out.println(mathCalculator);
        mathCalculator.add(10, 20);
        mathCalculator.div(10, 20);
        mathCalculator.sub(10, 20);
    }

    /**
     * 增强器链：切面中的所有通知方法其实就是增强器。他们被组织成一个链路放到集合中。目标方法真正执行前后,会去增强器链中执行那些需要提前执行的方法
     */
    @Test
    void test02(){

        userService.getUserHaha(1,2);
        System.out.println("======================");
        userService.updateUser(new Object());
    }

    @Test
    void test03(){

        // 代理对象执行切面x
//        mathCalculator.div(10, 2);
        mathCalculator.div(10, 0); // 测试异常
    }

}
