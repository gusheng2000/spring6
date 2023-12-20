package com.shichong;



import com.shichong.bean.User;
import org.dom4j.DocumentException;
import org.junit.Test;
import org.myspringframework.core.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void testApp() throws DocumentException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = (UserService)context.getBean("userService");
        Vip user = (Vip)context.getBean("vip");
        System.out.println(user);

        userService.createUser();
    }

}
