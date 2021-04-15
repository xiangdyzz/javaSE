package com.xiangdy.study.jdk8.defaultinterface;

public class Main {

    public static void main(String[] args) {
        Animal animal = new Animal() {
            /**
             * 只实现say函数
             */
            @Override
            public void say() {
                System.out.println("say hi");
            }
        };

        animal.say();
        animal.eat();
    }
}


/**
 * java8 接口增加默认函数,以突破为该接口增加函数，所有是实现类均需要实现
 */
interface Animal {

    void say();

    /**
     * default 关键字向接口添加非抽象方法实现
     */
    default void eat(){
        System.out.println("动物要吃东西");
    }
}
