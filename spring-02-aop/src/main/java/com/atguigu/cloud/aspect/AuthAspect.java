package com.atguigu.cloud.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 切面会根据首字母进行排序，字母顺序越靠前的，认为是越外层的切面，数字越小，越先执行
 */
//@Order(2) // 优先级，数字越小，优先级越高
@Component
@Aspect
public class AuthAspect {

    @Pointcut("execution(int com.atguigu.cloud.calculator.MathCalculator.*(..))")
    private void pointCut(){

    }

    @Before("pointCut()")
    public void before(){
        System.out.println("【切面 - 权限】前置....");
    }

    @After("pointCut()")
    public void after(){
        System.out.println("【切面 - 权限】后置....");
    }

    @AfterReturning("pointCut()")
    public void afterReturning(){
        System.out.println("【切面 - 权限】返回....");
    }

    @AfterThrowing("pointCut()")
    public void afterThrowing(){
        System.out.println("【切面 - 权限】异常....");
    }



}
