package com.xiangdy.study.annotation.entity;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author xiangDY
 * @Description: TODO
 * @date 2020/1/7　15:12
 */
@Component
public class SpringAware implements BeanNameAware, InstantiationAwareBeanPostProcessor, InitializingBean, DisposableBean {


    public SpringAware(){
        System.out.println("实例化");
    }

    /**
     * 获取自身在容器中注册成为的名字
     * @param s
     */
    @Override
    public void setBeanName(String s) {
        System.out.println("第一大类Aware"+s);
    }

    //实例化
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        System.out.println("实例化之前");
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        System.out.println("实例化之后");
        return false;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("初始化之后");
        return null;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("初始化之前");
        return null;
    }


    @Override
    public void destroy() throws Exception {
        System.out.println("容器销毁,容器托管的bean才会被销毁,除了被设置为");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("初始化之时,属性赋值之后");
    }
}
