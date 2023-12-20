package com.shichong.spring6.service;

import com.shichong.spring6.dao.UserDao;
import com.shichong.spring6.dao.VipDao;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryUtils;

/**
 * @Author sc
 * @ClassName CustomerService
 * @Description class function:
 * @Date 2023/12/16 16:12:38
 **/
public class CustomerService {
    private UserDao userDao;
    private VipDao  vipDao;

    public CustomerService(UserDao userDao, VipDao vipDao) {
        System.out.println("有参构造");
        this.userDao = userDao;
        this.vipDao = vipDao;
    }

    public void insert(){
        userDao.insert();
        vipDao.insert();
    }
}
