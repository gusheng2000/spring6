package com.shichong.bean;

import com.shichong.spring6.bean.User;
import com.shichong.spring6.bean.Vip;
import com.shichong.spring6.dao.UserDao;
import com.shichong.spring6.dao.impl.UserDaoImplByMysql;
import org.junit.Test;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @Author sc
 * @ClassName BeanFirstSpringTest
 * @Description class function:
 * @Date 2023/12/14 20:18:29
 **/

public class BeanFirstSpringTest {
    @Test
    public void testBeanFactory() {
        //ApplicationContext 接口是顶层父接口是BeanFactory (翻译为Bean工厂,就是能够生产bean对象的一个工厂对象
        // BeanFactory是 IoC 容器的顶级接口
        //Spring底层IoC是怎么实现的 ? xml解析+ 工厂模式 +反射机制
//      ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/xml/beans.xml","spring.xml","beans.xml");
        BeanFactory applicationContext = new ClassPathXmlApplicationContext("/xml/beans.xml","spring.xml","beans.xml");
        User user = (User) applicationContext.getBean("user");
        System.out.println(user);

    }


    @Test
    public void firstSpringTestCode() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("/xml/beans.xml","spring.xml","beans.xml");
        User user = (User) applicationContext.getBean("user");
        UserDaoImplByMysql userDao = (UserDaoImplByMysql) applicationContext.getBean("userDao");
        Vip vip = (Vip) applicationContext.getBean("vip");
        System.out.println(user);
        System.out.println(userDao);
        System.out.println(vip);
//        注入jdk内部的对象
        // 如果bean的name不存在 会报错 不会返回null
//        Object data =applicationContext.getBean("nowTime");
        Date date = applicationContext.getBean("nowTime", Date.class);
        System.out.println(date);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        System.out.println(format);
    }

    @Test
    public void testFileApplicationContext() {
        BeanFactory applicationContext = new FileSystemXmlApplicationContext("D:\\Work_Space\\Spring6\\Spring6\\spring6-002-first\\src\\main\\resources\\spring.xml");
        User user = (User) applicationContext.getBean("user");
        System.out.println(user);
    }


    @Test
    public void whenCreateBean() {
        BeanFactory applicationContext = new FileSystemXmlApplicationContext("D:\\Work_Space\\Spring6\\Spring6\\spring6-002-first\\src\\main\\resources\\spring.xml");
        //运行窗口 打印  (反射无参构造方法, 创建User)  所以在创建容器的时候就会常见Bean
    }

    @Test
    public void log4j(){
        Logger logger = LoggerFactory.getLogger(BeanFirstSpringTest.class);
        logger.info("我是一条信息");
        logger.warn("我是一条警告信息");
        logger.error("我是一条错误信息");
    }

    @Test
    public void firstSpringTestCodeSc() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        User user = (User) applicationContext.getBean("user");
        System.out.println(user);
        boolean simpleValueType = BeanUtils.isSimpleValueType(int.class);
        System.out.println(simpleValueType);
    }


}
