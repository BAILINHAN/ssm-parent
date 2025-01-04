package org.example.bean;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.Data;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

//BeanPostProcessor: Bean的修改器
@Data
public class User implements InitializingBean, DisposableBean {

    private String name;

    private String password;

    private Car car;

    /**
     * @Autowired 属性自动注入
     * @param car
     */
    @Autowired
    public void setCar(Car car) {
        System.out.println("自动注入：属性值: " + car);
        this.car = car;
    }

    public User(){

        System.out.println("User 构造器执行.....");
    }

    public void initUser(){

        System.out.println("@Bean 初始化：initUser");
    }

    public void destroyUser(){

        System.out.println("@Bean 销毁：destroyUser");
    }

    /**
     * 属性设置之后进行调用：set赋值完成了
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {

        System.out.println("[InitializingBean] ==== afterPropertiesSet.....");
    }

    /**
     * 销毁
     * @throws Exception
     */
    @Override
    public void destroy() throws Exception {

        System.out.println("[DisposableBean] ==== destroy.....");
    }

    /**
     * 构造器之后调用
     */
    @PostConstruct // 构造器之后
    public void postConstruct(){

        System.out.println("PostConstruct......");
    }

    /**
     * 销毁之前调用
     */
    @PreDestroy// 销毁之前
    public void preDestroy(){

        System.out.println("PreDestroy......");
    }
}
