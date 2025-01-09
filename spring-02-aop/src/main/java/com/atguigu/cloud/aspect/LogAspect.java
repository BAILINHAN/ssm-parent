package com.atguigu.cloud.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Aop的底层原理就是增强器链
 * 增强器链：
 *         切面中的所有通知方法其实就是增强器。他们被组织成一个链路放到集合中。目标方法真正执行前后,会去增强器链中执行那些需要提前执行的方法
 *         1. Spring会为每个被切面切入的组件创建代理对象
 *         2. 代理对象中保存了切面中所有通知方法构成的增强器链
 *         3. 目标方法执行时，会去先执行增强器链中需要提前执行的通知方法
 * 通知方法执行顺序：
 *          1. 正常链路： 前置通知 -> 目标方法 -> 返回通知 -> 后置通知
 *          2. 异常链路： 前置通知 -> 目标方法 -> 异常通知 -> 后置通知
 *
 */
//@Order(1)
@Component
@Aspect // 告诉Spring这个组件是个切面
public class LogAspect {

    /**
     * 告诉Spring 以下通知方法何时何地运行
     * 何时：
     *      @Before: 方法执行之前运行
     *      @AfterReturning: 方法正常返回之后运行
     *      @AfterThrowing: 方法抛出异常之后运行
     *      @After: 方法执行之后运行
     *      @Around: 环绕通知，可以决定目标方法执行还是不执行，并且可以修改目标方法的参数，执行结果等
     * 何地
     *      切入点表达式: @Before("execution(* com.atguigu.cloud.controller.*.*(..))")
     *      execution(方法的全签名):
     *          全写法：[public]? int [com.atguigu.cloud.calculator.Calculator]?.add(int i, int j) [throws Exception]
     *          省略写法：int add(int i, int j)
     *          通配符：*：表示任意字符
     *                ..:
     *                  1) 代表任意多个参数，任意类型
     *                  2) 放在包的位置，代表多个层级
     *          最省略：* *(..)
     *  JoinPoint joinPoint: 包装了目标方法信息
     *
     *
     */
//    @Before("execution(int *(int, int))")

    @Pointcut("execution(int com.atguigu.cloud.calculator.MathCalculator.*(..))")
    private void pointCut(){

    }

    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint){

        // 1. 拿到方法的全签名
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String name = signature.getName();
        // 目标方法传来的参数值
        Object[] args = joinPoint.getArgs();

        System.out.println("【切面 - 日志】【" + name + "】开始: 参数列表[" + Arrays.toString(args) +"]");
    }

//    @After("execution(int *(int, int))")
    @After("pointCut()")
    public void logEnd(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String name = signature.getName();
        System.out.println("【切面 - 日志】【" + name + "】后置结束.....");
    }

//    @AfterReturning("execution(int *(int, int))")
    @AfterReturning(value = "pointCut()",
            returning = "result") // returning = "result" 表示目标方法返回值
    public void logReturn(JoinPoint joinPoint, Object result){

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String name = signature.getName();
        System.out.println("【切面 - 日志】【" + name + "】返回的值:"+ result);
    }

//    @AfterThrowing("execution(int *(int, int))")
    @AfterThrowing(value = "pointCut()", throwing = "e")
    public void logException(JoinPoint joinPoint, Throwable e){ // 参数 Exception e 指需要捕获到的异常，如果指定某些异常，而未被捕获到，则不会调用logException方法

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String name = signature.getName();
        System.out.println("【切面 - 日志】【" + name + "】异常信息: " + e.getMessage());
    }

    // 参数带什么就切
//    @Before("args(int, int)")
//    public void haha(){
//        System.out.println("【切面 - 日志】测试.....");
//    }

    //
//    @Before("@args(com.atguigu.cloud.annotation.MyAnnotation) && within(com.atguigu.cloud.service.UserService)")
//    public void hehehe(){
//        System.out.println("【切面 - 日志】呵呵呵.....");
//    }
}
