package org.example;

import org.example.bean.User;
import org.example.dao.DeliveryDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.UUID;

@SpringBootTest
public class HelloTest {

    @Autowired
    User user;

    @Autowired
    DeliveryDao deliveryDao;

    @Test
    void test02(){
        String string = UUID.randomUUID().toString();
        System.out.println("string= " + string);

//        Object proxy = Proxy.newProxyInstance();

        InvocationHandler invocationHandler = new InvocationHandler() {

            /**
             *
             * @param proxy 代理对象
             * @param method 代理对象准备调用目标对象的方法
             * @param args 方法调用传递的参数
             *
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                // 目标方法执行
//                Object invoke = method.invoke(target, args);
//                return invoke;
                return null;
            }
        };

        // InvocationHandler 类似于拦截器
        InvocationHandler ihx = (proxy, method, args) ->{
            return null;
        };
    }

    @Test
    void test01(){

        System.out.println("User = " + user);
        deliveryDao.saveDelivery();
    }

}
