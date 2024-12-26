package org.example.config;

import org.example.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: solo.linhan
 * @Date: 2024/12/26 15:39
 */
// 配置类也是一个组件
@Configuration // 告诉Spring容器，这是一个配置类
public class PersonConfig {

    // 给容器中注册一个自己的组件
    // 给容器重新命名为 "hahaha"
    @Bean("hahaha") //@Bean 注解将对对象放入容器中 容器中的每个组件都有自己的名字，方法名就是组件的名字
    public Person person(){

        Person person = new Person();
        person.setAge(20);
        person.setName("张三");
        person.setGender("男");
        return person;
    }

}
