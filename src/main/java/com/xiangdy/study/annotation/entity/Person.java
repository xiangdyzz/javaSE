package com.xiangdy.study.annotation.entity;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author xiangDY
 * @Description: TODO
 * @date 2019/12/27　11:04
 */
@Data
public class Person {


    String name;
    Integer age;


    @Transactional
    public void init(){
        System.out.println("初始化");
    }
    public void destroy(){
        System.out.println("销毁");
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

}
