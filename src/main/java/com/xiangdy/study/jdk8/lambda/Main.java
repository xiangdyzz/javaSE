package com.xiangdy.study.jdk8.lambda;

public class Main {

    public static void main(String[] args) {
        /**
         * 匿名内部类写法
         */
        Student student1 = new Student() {
            @Override
            public void study(String name) {
                System.out.println(name+"在读书");
            }
        };

        //lambda表达式写法
        Student student = item -> System.out.println(item+"在读书");
        student.study("张三");
    }


    /**
     * 函数接口
     */
    @FunctionalInterface
    interface Student{
        void study(String name);
    }
}
