package com.shichong;

import com.shichong.bean.UserService;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.dom4j.DocumentException;
import org.junit.Test;
import org.myspringframework.core.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class testSimpleApp  {


    /**
     * Rigourous Test :-)
     */
    @Test
    public void testApp() throws DocumentException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService =(UserService) context.getBean("userService");
        userService.createUser();
    }
}
