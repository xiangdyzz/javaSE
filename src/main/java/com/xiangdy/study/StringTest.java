package com.xiangdy.study;

/**
 * @author xiangDY
 * @Description: 测试字符串存储存储入字符串常量池中
 * @date 2019/12/24　13:55
 */
public class StringTest {


    public static void main(String[] args) {


        String s1 = "xiangDY";//将会在堆中创建字符串对象，并存储进常量池中
        String s2 = "xiangDY";//直接指向常量池中的对象;
        String s3 = new String("xiangDY");//在堆中创建一个新的引用指向s3

        System.out.println(s1 == s2);
        System.out.println(s1 == s3);

        String s4 = s3.intern();//如果常量池中包含等于此字符串对象的字符串(使用equals函数确定)，则直接指向该应用，否则将该对象添加到常量池中

        System.out.println(s1 == s4);
        System.out.println(s3 == s4);


    }

    public void test(){
        System.out.println("public method");
    }

    public static void staticTest(){
        System.out.println("public static method");
    }
}
