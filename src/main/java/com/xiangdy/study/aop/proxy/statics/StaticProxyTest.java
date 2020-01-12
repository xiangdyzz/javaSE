package com.xiangdy.study.aop.proxy.statics;

/**
 * @author xiangDY
 * @Description: TODO
 * @date 2020/1/12　9:13
 */
public class StaticProxyTest {

    public static void main(String[] args) {
        LoginService loginService = new LoginServiceProxy(new LoginServiceImpl("xiangDY"));
        loginService.login();
    }
}
