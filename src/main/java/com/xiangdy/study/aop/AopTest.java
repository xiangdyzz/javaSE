package com.xiangdy.study.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author xiangDY
 * @Description: TODO
 * @date 2020/1/11　14:18
 */
public class AopTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AopConfig.class);
        MathDivision mathDivision = (MathDivision) applicationContext.getBean("mathDivision");
//        int a = mathDivision.div(1,1);
//        System.out.println(a);
    }
}
