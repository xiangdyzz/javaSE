package com.xiangdy.study.annotation.entity;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

/**
 * @author xiangDY
 * @Description: TODO
 * @date 2020/1/7　15:12
 */
@Component
public class SpringAware implements BeanNameAware {

    /**
     * 获取自身在容器中注册成为的名字
     * @param s
     */
    @Override
    public void setBeanName(String s) {
        System.out.println(s);
    }
}
