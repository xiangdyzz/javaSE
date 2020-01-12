package com.xiangdy.study.aop.proxy.cglib;

/**
 * @author xiangDY
 * @Description: TODO
 * @date 2020/1/12　11:42
 */
public class CglibProxyTest {

    public static void main(String[] args) {
        LoginService loginService = new CglibProxy().getInstance(LoginService.class);
        loginService.login();
    }
}
