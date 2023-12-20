package com.shichong;

import com.shichong.spring6.bean.*;
import com.shichong.spring6.jdbc.MyDataSource;

import com.shichong.spring6.service.CustomerService;
import com.shichong.spring6.service.OrderService;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.Date;

/**
 * Unit test for simple App.
 */
public class AppTest {
    @Test
    public void constructorDi() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        CustomerService customerService = applicationContext.getBean("customerService", CustomerService.class);
        CustomerService csBean2 = applicationContext.getBean("csBean2", CustomerService.class);
        CustomerService csBean3 = applicationContext.getBean("csBean3", CustomerService.class);
        csBean3.insert();
        System.out.println(customerService);
        System.out.println(csBean2);
        System.out.println(csBean3);
    }
    @Test
    public void testDI() {

    }

    //简单类型注入
    @Test
    public void testDI2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("set-di.xml");
        User user = context.getBean("user", User.class);
        System.out.println(user);

    }

    @Test
    public void firstSpringTestCode01() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("set-di.xml");
        SimpleValueType simpleValueType1 = applicationContext.getBean("simpleValueType", SimpleValueType.class);
        System.out.println(simpleValueType1);
    }


    @Test
    public void testMyDataSource() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("set-di.xml");
        MyDataSource datasource = applicationContext.getBean("dataSource", MyDataSource.class);
        System.out.println(datasource);
    }

    @Test
    public void testCascade() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("cascade.xml");
        Clazz clazz = applicationContext.getBean("clazz", Clazz.class);
        Student student = applicationContext.getBean("student", Student.class);
        System.out.println(clazz);
        System.out.println(student);

    }

    @Test
    public void tetsArrayString() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-array.xml");
        YuQian yuQian = applicationContext.getBean("yuQian", YuQian.class);
        System.out.println(yuQian);
    }

    @Test
    public void autoWireByname() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-autoWire.xml");
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
        orderService.insert();
        System.out.println(orderService);
    }

    @Test
    public void autoWireByType() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-autoWire.xml");
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
        orderService.insert();
        System.out.println(orderService);
    }

}
