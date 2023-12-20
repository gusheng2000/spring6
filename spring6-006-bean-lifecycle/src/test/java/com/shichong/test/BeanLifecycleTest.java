package com.shichong.test;

import com.shichong.bean.Student;
import com.shichong.bean.User;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author sc
 * @ClassName BeanLifecycleTest
 * @Description class function:
 * @Date 2023/12/18 19:00:51
 **/
public class BeanLifecycleTest {
    @Test
    public void test(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        User user = context.getBean("user", User.class);
        System.out.println("第四步 使用bean:"+user.toString());
        context.close();
    }

    @Test
    public void test02(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        User user = context.getBean("user", User.class);
        System.out.println("第四步 使用bean:"+user.toString());
        context.close();
    }

    /**
     * 自己new的对象如何交给spring容器管理?
     */
    @Test
    public void test03(){
        Student student = new Student();
        System.out.println(student);
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        factory.registerSingleton("student",student);
        Student bean = factory.getBean("student", Student.class);
        System.out.println(bean);

    }
}
