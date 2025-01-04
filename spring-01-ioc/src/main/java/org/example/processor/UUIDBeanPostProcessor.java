package org.example.processor;

import org.example.annotation.UUID;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class UUIDBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        // 利用反射拿到所有属性
        Field[] declaredFields = bean.getClass().getDeclaredFields();
        // 扫描属性头上所有的注解
        for(Field declaredField : declaredFields) {

            // 判断是否有@UUID的注解
            if(declaredField.isAnnotationPresent(UUID.class)){

                declaredField.setAccessible(true);
                // 设置一个UUID给对应的属性
                try {
                    declaredField.set(bean, java.util.UUID.randomUUID().toString());
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }

        }

        //返回该对象
        return bean;
    }
}
