package com.xiangdy.study.aop.proxy.dynamic;

/**
 * @author xiangDY
 * @Description: 登录业务实现类
 * @date 2020/1/12　9:23
 */
public class LoginServiceImpl implements LoginService {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public LoginServiceImpl(String name) {
        this.name = name;
    }

    @Override
    public void login() {
        System.out.println(name+"login...");
    }
}
