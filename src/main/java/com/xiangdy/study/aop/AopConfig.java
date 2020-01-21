package com.xiangdy.study.aop;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author xiangDY
 * @Description: aop配置类,该类将被手动调用，初始化spring的相关容器
 * @date 2020/1/11　14:18
 */
@ComponentScan("com.xiangdy.study.aop") //配置容器扫描bean路径
@EnableAspectJAutoProxy  //开启aop自动代理
public class AopConfig implements ImportBeanDefinitionRegistrar{

}
