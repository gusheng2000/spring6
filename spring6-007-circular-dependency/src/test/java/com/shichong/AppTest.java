package com.shichong;

import com.shichong.bean.HusBand;
import com.shichong.bean.Wife;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: shichong1008@outlook.com
 * @Description: TODO
 * @DateTime: 2023/12/20 17:28
 **/
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