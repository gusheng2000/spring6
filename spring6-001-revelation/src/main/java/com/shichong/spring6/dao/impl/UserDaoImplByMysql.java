package com.shichong.spring6.dao.impl;

import com.shichong.spring6.dao.UserDao;

/** 数据持久层
 * @Author sc
 * @ClassName UserDaoImpl
 * @Description class function:
 * @Date 2023/12/12 22:26:02
 **/
public class UserDaoImplByMysql implements UserDao {
    @Override
    public void deleteById() {
        System.out.println("mysql正在删除用户信息");
    }
}
