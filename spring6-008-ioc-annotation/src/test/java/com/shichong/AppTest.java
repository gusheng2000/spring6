package com.shichong;

import com.shichong.spring6.bean.App;
import com.shichong.spring6.bean.User;
import com.shichong.spring6.bean.Vip;
import com.shichong.spring6.bean3.Girl;
import com.shichong.spring6.bean3.MyDataSource;
import com.shichong.spring6.config.Spring6Config;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void testAnnotationTest(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Vip vip = context.getBean("vipBean", Vip.class);
        User user = context.getBean("userBean", User.class);
        App app = context.getBean("appBean", App.class);

        System.out.println(vip);
        System.out.println(user);
        System.out.println(app);
    }
    @Test
    public void testAnnotationTest02(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-choose.xml");
    }

    @Test
    public void testAnnotationTest03(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-annotation-di.xml");
        MyDataSource dataSource = context.getBean("myDataSource", MyDataSource.class);
        System.out.println(dataSource);
    }

    @Test
    public void testAnnotationTest04(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-annotation-di.xml");
        Girl girl = context.getBean("girl", Girl.class);
        System.out.println(girl);
    }

    @Test
    public void testAnnotationConfigTest(){
        ApplicationContext context = new AnnotationConfigApplicationContext(Spring6Config.class);
        Girl girl = context.getBean("girl", Girl.class);
        System.out.println(girl);
    }

}
