package com.shichong;

import com.shichong.bean.HusBand;
import com.shichong.bean.Wife;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 循环依赖模拟测试
 * Unit test for simple App.
 */

public class AppTest {
    /**
     * 在单例模式下循环依赖
     */
    @Test
    public void test01() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        Wife wife= context.getBean("wife", Wife.class);
        System.out.println(wife);

        HusBand husBand = context.getBean("husBand", HusBand.class);
        System.out.println(husBand);
    }
}
