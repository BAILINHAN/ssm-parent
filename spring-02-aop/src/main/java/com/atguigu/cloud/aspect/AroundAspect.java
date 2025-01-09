package com.atguigu.cloud.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 模板化的业务逻辑，推荐使用切面去做
 */
@Aspect
@Component
public class AroundAspect {

    @Pointcut("execution(int com.atguigu.cloud.calculator.MathCalculator.*(..))")
    private void pointCut(){

    }

    /**
     * 环绕通知固定写法如下：
     * public Object around(ProceedingJoinPoint pjp) throws Throwable {}
     * Object: 返回值
     * ProceedingJoinPoint: 可以继续推进的切点
     *
     */
    @Around("pointCut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        // 环绕前置通知
        System.out.println("环绕 - 前置通知");
        // 修改参数
        Object[] args = pjp.getArgs(); // 获取目标方法的参数
//        pjp.proceed(args);// 使用接收传参的proceed方法
        // pjp.proceed();
        Object obj = null;
        try {

            obj = pjp.proceed(); // 执行目标方法
            // 返回通知
            System.out.println("环绕 - 返回通知");
        }catch (Exception e){
            // 环绕通知要吃掉异常-抛出异常
            System.out.println("环绕 - 异常通知:" + e.getCause());// 异常通知
            throw e; // 留给别人继续感知
        }finally {

            System.out.println("环绕 - 后置通知");

        }
        // 后置通知
        System.out.println("环绕 - 后置通知");
        // 可以修改返回值
        return obj;
    }

}
