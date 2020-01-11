package com.xiangdy.study.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * @author xiangDY
 * @Description: 日志切入类
 * @date 2020/1/11　14:18
 */
@Aspect
@Component
public class LogAspect {

    /**
     * 抽取公共的切入点表达式
     */
    @Pointcut(value = "execution(public int com.xiangdy.study.aop.MathDivision.div(int,int))")// 切入这个类的div函数
    public void pointCut(){};


    @Before("pointCut()")
    public void divBefore(JoinPoint pointcut){
        print("Before   ",pointcut,null);
    }


    @After("com.xiangdy.study.aop.LogAspect.pointCut()")//外部调用切入点
    public void divAfter(JoinPoint pointcut){
        print("After   ",pointcut,null);
    }

    /**
     * returning = "result" 标识返回值赋值给函数中的result形参
     * @param pointcut
     * @param result
     */
    @AfterReturning(value = "pointCut()",returning = "result")
    public void divAfterReturn(JoinPoint pointcut,Object result){
        print("AfterReturning   ",pointcut,result);
    }

    /**
     *  throwing = "exception" 标识异常信息将被回调到这个函数中的exception参数
     * @param pointcut
     * @param exception
     */
    @AfterThrowing(value = "pointCut()",throwing = "exception")
    public void divAfterThrowing(JoinPoint pointcut,Exception exception){
        print("AfterThrowing   ",pointcut,exception);
    }


    public void print(String aspectMethod,JoinPoint pointcut,Object object){
        System.out.println(aspectMethod+pointcut.getSignature().getName()+"被调用  ==》"+object);
    }
}
