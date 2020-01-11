package com.xiangdy.study.annotation.entity;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;

/**
 * @author xiangDY
 * @Description: TODO
 * @date 2019/12/31　9:24
 */
public class PersonFactory implements FactoryBean<Person> {
    @Override
    public Person getObject() throws Exception {
        return new Person("xiangDY",23);
    }

    @Override
    public Class<?> getObjectType() {
        return Person.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
