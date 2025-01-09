package com.atguigu.cloud.service;

import com.atguigu.cloud.annotation.MyAnnotation;

public interface UserService {

    void saveUser();

    void getUserHaha(int i, int j);

    void updateUser(@MyAnnotation Object o);
}
