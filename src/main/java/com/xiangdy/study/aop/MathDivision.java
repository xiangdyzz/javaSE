package com.xiangdy.study.aop;

import org.springframework.stereotype.Component;

/**
 * @author xiangDY
 * @Description: 数学除法业务类
 * @date 2020/1/11　14:16
 */
@Component
public class MathDivision {

    public int div(int a,int b){
        System.out.println(a+"/"+b);
        return a/b;
    }
}
