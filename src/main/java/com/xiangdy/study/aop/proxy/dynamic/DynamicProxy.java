package com.xiangdy.study.aop.proxy.dynamic;

import com.xiangdy.study.aop.proxy.statics.LoginService;
import com.xiangdy.study.aop.proxy.statics.LoginServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author xiangDY
 * @Description: 登录日志动态代理类
 *
 * 通过JDK原生反射动态创建代理类。生成效率较高
 *
 * 缺点：在使用时，业务代码还是和代理日志代码耦合在一起了  只能对接口进行代理
 * 调用业务代码时，需要先动态创建业务代理类
 * DynamicProxy<LoginServiceImpl>(new LoginServiceImpl("xiangDY")).getProxyInstance();
 *
 * 优点：动态代理,不必再为一个业务类创建一个代理类，任何业务代理都通过一个代理类实现
 * @date 2020/1/12　9:24
 */
public class  DynamicProxy <T>{
    private T target ;

    public DynamicProxy(T target){
        this.target = target;
    }

    public T getProxyInstance(){
        return (T)Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            //我现在的疑问是这些参数是被谁传入的
            //也就是这个类的这个 invoke函数是如何被调用的
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                before();
                Object result = method.invoke(target,args);
                after();
                return result;
            }
        });
    }

    private void before(){ System.out.println("登录之前日志记录");}
    private void after(){ System.out.println("登录之后日志记录");}

}
