## 静态代理是利用java的多态实现的
- 登录业务接口
```java
public interface LoginService {
    void login();
}
```
- 登录业务实现类
```java
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
```
- 登录业务代理类
```java
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

    private void before(){
        System.out.println(loginService.getName()+"登录之前日志记录");
    }
    private void after(){ System.out.println(loginService.getName()+"登录之后日志记录");}
}
```
- 测试
```java
public class StaticProxyTest {

    public static void main(String[] args) {
        LoginService loginService = new LoginServiceProxy(new LoginServiceImpl("xiangDY"));
        loginService.login();
        
        //console log
        //xiangDY登录之前日志记录
        //xiangDYlogin...
        //xiangDY登录之后日志记录
    }
}
```
    优缺点：
    - 优点是在静态编译时将代理函数编织在一起，性能较高
    - 缺点是如果增加一个业务类还需要再增加一个静态代理类，扩展性极差
