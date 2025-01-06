package com.atguigu.cloud;

import com.atguigu.cloud.calculator.MathCalculator;
import com.atguigu.cloud.calculator.impl.MathCalculatorImpl;
import com.atguigu.cloud.proxy.dynamic.DynamicProxy;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MathTest {

    @Test
    void test01(){

        // 强制类型转换为接口形式
        MathCalculator proxyInstance = (MathCalculator) DynamicProxy.getProxyInstance(new MathCalculatorImpl());
        int addResult = proxyInstance.add(1, 2);
        System.out.println(addResult);
    }
}
