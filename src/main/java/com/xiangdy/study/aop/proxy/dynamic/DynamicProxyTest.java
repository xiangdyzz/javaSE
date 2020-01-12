package com.xiangdy.study.aop.proxy.dynamic;

/**
 * @author xiangDY
 * @Description: 动态代理测试
 * @date 2020/1/12　10:11
 */
public class DynamicProxyTest {

    public static void main(String[] args) {
        LoginService loginService = new DynamicProxy<LoginServiceImpl>(new LoginServiceImpl("xiangDY")).getProxyInstance();
        loginService.login();
    }
}
