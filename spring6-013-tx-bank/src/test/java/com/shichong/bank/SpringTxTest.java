package com.shichong.bank;


import com.shichong.bank.cinfig.SpringConfig;
import com.shichong.bank.pojo.Account;
import com.shichong.bank.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author sc
 * @ClassName SpringTxTest
 * @Description class function:
 * @Date 2023/12/21 21:03:17
 **/
public class SpringTxTest {
    @Test
    public void testSpringTx() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        AccountService accountService = context.getBean("accountService", AccountService.class);
        accountService.transfer("001", "002", 10000.00);
//        System.out.println("转账成功");
    }

    @Test
    public void testSpringTxPropagation() {
//        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        AccountService accountService = context.getBean("accountService", AccountService.class);
        accountService.save(new Account("003", 10000.00));
//        System.out.println("转账成功");
    }


}
