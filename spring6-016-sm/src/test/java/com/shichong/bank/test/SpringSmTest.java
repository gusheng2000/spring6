package com.shichong.bank.test;

import com.shichong.bank.service.AccountService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringSmTest {

    @Test
    public void test() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-sm.xml");
        AccountService service = context.getBean("accountService", AccountService.class);
        try {
            service.transfer("001","002",10000.00);
            System.out.println("转账成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
