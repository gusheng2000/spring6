package com.shichong.factory;

import com.shichong.bean.Person;
import org.springframework.beans.factory.FactoryBean;

/**
 * @Author sc
 * @ClassName PersonFactoryBean
 * @Description class function:
 * @Date 2023/12/17 14:28:12
 **/
public class PersonFactoryBean implements FactoryBean<Person> {
    @Override
    public Person getObject() throws Exception {
        return new Person();
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }
}
