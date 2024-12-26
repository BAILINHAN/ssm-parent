package org.example;

import org.example.bean.Dog;
import org.example.bean.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Map;

/**
 * 主入口类
 */
@SpringBootApplication
public class Spring01IocApplication
{

    /**
     * Spring提供了快速的Mvc分层注解
     * 1、 @Controller 控制器
     * 2、 @Service 服务层
     * 3、 @Repository 持久层
     * 4、 @Component 组件
     *
     */

    /**
     * 组件：框架的底层配置
     *  配置文件：指定配置
     *  配置类：
     * 组件的创建时机，容器启动过程中就会创建组件对象
     ** 单实例特性：所有组件默认是单实例的，每次获取直接从容器中拿取，容器会提前创建
     */
    public static void main(String[] args) {
        // 跑起一个Spring应用，ApplicationContext：Spring应用的上下文对象，IOC容器
        ConfigurableApplicationContext ioc = SpringApplication.run(Spring01IocApplication.class, args);
        System.out.println("ioc = " + ioc);

        // 容器中装了哪些组件，获取容器中所有组件的名字
        String[] iocNames = ioc.getBeanDefinitionNames();
        for (String iocName : iocNames) {

            System.out.println("iocName = " + iocName);
        }

        // 获取容器中的组件对象
        // 组件的三大特性：名字、类型、作用域
        // 1) 如果组件不存在，抛 NoSuchBeanOfDefinitionException bean定义异常
        Person personHaha = (Person) ioc.getBean("hahaha");
        // 按照名字 + 类型
        Person person = ioc.getBean("hahaha", Person.class);
        System.out.println("person = " + person);
        System.out.println("person = " + personHaha);

        // 按照组件类型获取对象
        // 组件名字全局唯一 如果组件名字重复了，一定只会给容器中放一个最先声明的那个组件
        Person personBean = ioc.getBean(Person.class);
        Dog dogBean = ioc.getBean(Dog.class);
        // 2) 组件不唯一 NoUniqueBeanDefinitionException
        System.out.println("personBean:" + personBean);
        System.out.println("dogBean:" + dogBean);

        // 获取该类型的所有对象的Map
        Map<String, Person> beansOfType = ioc.getBeansOfType(Person.class);
        System.out.println("PersonMap:" + beansOfType);

    }



}
