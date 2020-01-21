package com.xiangdy.study.annotation.configuration;

import com.xiangdy.study.annotation.entity.Car;
import com.xiangdy.study.annotation.entity.Cat;
import com.xiangdy.study.annotation.entity.Person;
import com.xiangdy.study.annotation.entity.PersonFactory;
import org.springframework.context.annotation.*;

import java.security.PublicKey;

/**
 * @author xiangDY
 * @Description: TODO
 * @date 2019/12/27　11:13
 */

/**
 * 配置PropertySource导入properties文件
 */
@Configuration
@PropertySource(value = {"classpath:/application.properties"})
@ComponentScan("com.xiangdy.study.annotation")
public class PersonConfiguration {

}
