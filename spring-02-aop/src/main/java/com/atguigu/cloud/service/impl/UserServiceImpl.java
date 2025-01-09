package com.atguigu.cloud.service.impl;

import com.atguigu.cloud.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public void saveUser() {
        System.out.println("业务：保存用户");
    }

    @Override
    public void getUserHaha(int i, int j) {
        System.out.println("业务：查询用户");
    }

    @Override
    public void updateUser(Object o) {
        System.out.println("哈哈哈....有@MyAnnotation注解");
    }
}
