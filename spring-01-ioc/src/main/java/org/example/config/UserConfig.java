package org.example.config;

import org.example.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean(initMethod = "initUser", destroyMethod = "destroyUser")
    public User user(){

        return new User();
    }

}