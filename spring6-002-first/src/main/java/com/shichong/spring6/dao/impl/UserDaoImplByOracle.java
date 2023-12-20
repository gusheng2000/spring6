package com.shichong.spring6.dao.impl;

import com.shichong.spring6.dao.UserDao;

/**
 * @Author sc
 * @ClassName UserDaoImplByOracle
 * @Description class function:
 * @Date 2023/12/12 23:01:04
 **/
public class UserDaoImplByOracle implements UserDao {
    @Override
    public void deleteById() {
        System.out.println("oracle deleteById");
    }
}
