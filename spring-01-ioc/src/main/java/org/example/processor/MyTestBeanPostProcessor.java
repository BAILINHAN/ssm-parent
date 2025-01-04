package org.example.processor;

import org.example.bean.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * 拦截所有Bean的后置处理器
 * bean的生命周期：
 *  1. 创建周期
 *  2. 初始化周期：初始化之前，使用 postProcessAfterInitialization 进行拦截；初始化之后，使用 postProcessAfterInitialization 进行拦截
 *  3. 运行周期
 *  4. 销毁周期
 * @Autowired注解是如何实现的
 * 1. 专门有一个处理@Autowored注解的后置处理器：AutowiredAnnotationBeanPostProcessor
 * 2. 每个Bean创建后，会调用BeanPostProcessor的 postProcessBeforeInitialization 方法
 * 3. postProcessBeforeInitialization 里面就会利用反射，得到当前bean的所以属性，再利用反射得到bean上标注的所有注解，看有没有@Autowired注解
 * 4. 如果有，去容器中找到这个属性的对应组件（先按类型找，再按名称匹配）找到
 */
@Component
public class MyTestBeanPostProcessor implements BeanPostProcessor {

    /**
     * 在初始化之后调用
     * @param bean the new bean instance
     * @param beanName the name of the bean
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        System.out.println("【postProcessAfterInitialization】:" + beanName);
        return bean;
    }

    /**
     * 在初始化之前，构造器之后调用
     * @param bean the new bean instance
     * @param beanName the name of the bean
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        System.out.println("【postProcessBeforeInitialization】:" + beanName);

        // 如果是User类型的bean，则重新赋值name属性，并返回赋值后的对象
        if(bean instanceof User user){

            user.setName("BeanPostProcessor测试.....");
            return user;
        }

        return bean;
    }
}
