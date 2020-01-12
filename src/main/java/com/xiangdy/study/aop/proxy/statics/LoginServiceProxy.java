package com.xiangdy.study.aop.proxy.statics;

/**
 * @author xiangDY
 * @Description: 登录日志静态代理类
 * 多态+抓取引用     静态代理将握住实际业务类的应用，在使用前后操作，以达到代理场景
 * 缺点：打印的日志不可能只有登录，如果是新增用户也需要代理记录日志，那么就需要增加一个新增用户业务代理类，扩展性极差
 * 优点：在静态编译时将代码通过多态编织在一起，性能较高
 * @date 2020/1/12　9:24
 */
public class LoginServiceProxy implements LoginService {
    private LoginServiceImpl loginService ;

    public LoginServiceProxy(LoginServiceImpl loginService){
        this.loginService = loginService;
    }

    @Override
    public void login() {
        before();
        loginService.login();
        after();
    }

    private void before(){ System.out.println(loginService.getName()+"登录之前日志记录");}

    private void after(){ System.out.println(loginService.getName()+"登录之后日志记录");}
}
