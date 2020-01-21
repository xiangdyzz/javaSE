package com.xiangdy.study.annotation.entity;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.xml.soap.Name;
import java.math.BigDecimal;

/**
 * @author xiangDY
 * @Description: TODO
 * @date 2019/12/31　9:56
 */
public class Car implements InitializingBean, DisposableBean {

    /**
     * 1.默认按照类型取值
     * 2.如果该类型的对象有多个，则按照字段名称取值
     * 3.使用@Qualifier
     * 4.在Bean注册到spring容器中的时候使用@Primary注解标识首选
     *  @Qualifier > @Primary >  字段名称 > Class对象
     */
       @Qualifier("person1")
       @Autowired
       private Person person2;


       @Value("2") //普通直接反射获取到普通的值
       public  String name;
       @Value("#{23 - 2}")  //使用SPEL表达式赋值
       public Integer age;
       @Value(value = "${car.nickName") //第三种获取PropertiesResource中的缓存的Key值赋值
       public String nickName;
       private Integer money;



       public  Car(){}

       public Car(int money)  {
          this.money = money;
       }

        @Override
        public String toString() {
            return "Car{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}' +
                    ", nickName=" + nickName +
                    '}'+person2;
        }

        @Override
        public void destroy() throws Exception {
            System.out.println("car destroy");
        }

        @Override
        public void afterPropertiesSet() throws Exception {
            System.out.println("car init");
        }
}
