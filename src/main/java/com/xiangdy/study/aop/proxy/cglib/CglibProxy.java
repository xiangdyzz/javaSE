package com.xiangdy.study.aop.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author xiangDY
 * @Description: 通过ASM框架操作字节码生成文件，执行效率较高    且可以对普通类进行代理
 * @date 2020/1/12　11:29
 */
public class CglibProxy  {

    public <T> T getInstance(Class<T> tClass) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(tClass);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                before();
                Object result = methodProxy.invokeSuper(o, objects);
                after();
                return result;
            }
        });
        return (T) enhancer.create(); //创建一个被代理的类的子类，且拦截所有的方法调用
    }

    private void before(){ System.out.println("登录之前日志记录");}
    private void after(){ System.out.println("登录之后日志记录");}
}
