package com.xiangdy.study.annotation;

import com.xiangdy.study.annotation.configuration.PersonConfiguration;
import com.xiangdy.study.annotation.entity.Car;
import com.xiangdy.study.annotation.entity.Person;
import com.xiangdy.study.annotation.entity.PersonFactory;
import com.xiangdy.study.annotation.entity.SpringBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PostConstruct;
import java.io.File;
import java.net.URL;
import java.util.Arrays;

/**
 * @author xiangDY
 * @Description: TODO
 * @date 2019/12/27　11:02
 */


public class AnnotationIOC {


    public static void main(String[] args) {
        ApplicationContext application = new AnnotationConfigApplicationContext(PersonConfiguration.class);
        SpringBean springBean = (SpringBean) application.getBean("springBean");
        ((AnnotationConfigApplicationContext) application).close();
    }
}
