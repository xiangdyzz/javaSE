package com.xiangdy.study.jdk8.methodreference;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * java8 方法引用语法
 */
public class Main {
    public static void main(String[] args) {
        //实例函数
        Engineer engineer = new Engineer();
        Consumer<String> consumer = engineer::say;

        //静态函数
        Consumer<String> consumer1 = Engineer::staticSay;

        //构造函数
        Supplier<Engineer> supplier = Engineer::new;
    }
}
