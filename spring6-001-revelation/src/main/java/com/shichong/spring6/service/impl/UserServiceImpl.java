package com.shichong.spring6.service.impl;

import com.shichong.spring6.dao.UserDao;
import com.shichong.spring6.service.UserService;

/**
 * 业务层
 *
 * @Author sc
 * @ClassName UserServiceImpl
 * @Description class function:
 * @Date 2023/12/12 22:29:13
 **/
public class UserServiceImpl implements UserService {
    //    private UserDao userDao = new UserDaoImplByMysql();
    //    private UserDao userDao = new UserDaoImplByOracle();
    /**
     * 不在具体指定是哪个实现类 UserServiceImpl中的userDao
     * 到底是哪个由后面 配置bean的xml来指定，然后自动注入
     */
    private UserDao userDao;
    @Override
    public void delete() {
        userDao.deleteById();
    }
}
