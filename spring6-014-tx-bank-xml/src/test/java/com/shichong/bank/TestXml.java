package com.shichong.bank;

import com.shichong.bank.pojo.Account;
import com.shichong.bank.service.AccountService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestXml {

    @Test
    public void testSpringTxPropagation() {
//        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        AccountService accountService = context.getBean("accountService", AccountService.class);
        accountService.transfer("001","002", 10000.00);
//        System.out.println("转账成功");
    }

}
