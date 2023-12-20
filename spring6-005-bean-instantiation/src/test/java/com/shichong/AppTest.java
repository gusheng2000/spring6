package com.shichong;

import com.shichong.bean.*;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class AppTest {
    //构造方法创建
    @Test
    public void test01() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        SpringBean springBean = context.getBean("sb", SpringBean.class);
        System.out.println(springBean);
    }

    //简单工厂方法
    @Test
    public void test02() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Star star = context.getBean("star", Star.class);
        System.out.println(star);
    }

    @Test
    public void test03() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Gun gun = context.getBean("gun", Gun.class);
        System.out.println(gun);
    }


    @Test
    public void test04() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Person person = context.getBean("person", Person.class);
        System.out.println(person);
    }

    @Test
    public void test05() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Student student = context.getBean("student", Student.class);
        System.out.println(student);
    }

}
