package com.xiangdy.study.annotation.entity;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author xiangDY
 * @Description: TODO
 * @date 2019/12/31　11:28
 */
public class Cat implements InitializingBean, DisposableBean {

    public Cat(){
        System.out.println("Cat ");
    }

    @PostConstruct //在构造函数之后执行
    public void postConstruct(){
        System.out.println("cat PostConstruct ...");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("cat PreDestroy ...");
    }

    //申明初始化
    public void catInit(){
        System.out.println("cat init ...");
    }

    public void catDestroy(){
        System.out.println("cat destroy ...");
    }

    @Override //装配属性之后
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean destroy");
    }
}
