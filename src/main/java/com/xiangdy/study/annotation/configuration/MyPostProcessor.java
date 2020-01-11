package com.xiangdy.study.annotation.configuration;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.security.PublicKey;

/**
 * @author xiangDY
 * @Description: TODO
 * @date 2020/1/2　10:35
 */
public class MyPostProcessor implements BeanPostProcessor {

    //初始化之前开始执行
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization===>"+bean);
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization===>"+bean);
        return bean;
    }
}
