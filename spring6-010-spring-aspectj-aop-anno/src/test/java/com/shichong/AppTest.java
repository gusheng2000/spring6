package com.shichong;



import com.shichong.service.OrderService;
import com.shichong.service.UserService;
import com.shichong.service.config.AnnotationConfig;
import com.shichong.service.pojo.Order;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class AppTest {
    @Test
    public void testAop() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        UserService service = context.getBean("userService", UserService.class);
        service.login();
    }



    @Test
    public void testAop02() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AnnotationConfig.class);
        UserService service = context.getBean("userService", UserService.class);
        service.login();
    }

    @Test
    public void testAop03() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AnnotationConfig.class);
        OrderService service = context.getBean("orderService", OrderService.class);

        String bbc = service.getOrder(new Order("100", "BBC"));
        System.out.println(bbc);
    }
}
