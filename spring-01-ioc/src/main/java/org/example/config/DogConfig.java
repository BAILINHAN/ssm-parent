package org.example.config;

import org.example.bean.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: solo.linhan
 * @Date: 2024/12/26 17:19
 */
@Configuration
public class DogConfig {

    @Bean
    public Dog dog(){

        return new Dog();
    }

}
