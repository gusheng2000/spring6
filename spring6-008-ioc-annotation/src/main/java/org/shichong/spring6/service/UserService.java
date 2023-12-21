package org.shichong.spring6.service;

import org.shichong.spring6.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @Author: shichong1008@outlook.com
 * @Description: TODO
 * @DateTime: 2023/12/21 9:43
 **/
@Service
public class UserService {



//    @Qualifier("userDaoByMysql")
    @Autowired
    private UserDao userDao;


    /*
        如果一个类的构造方法只有一个，并且构造方法的参数能和属性对应的上@autowire可以省略
     */
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

//    @Autowired
//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }

    public void save() {
        userDao.save();
    }
}

