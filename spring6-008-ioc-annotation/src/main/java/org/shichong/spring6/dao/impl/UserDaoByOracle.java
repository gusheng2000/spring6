package org.shichong.spring6.dao.impl;

import org.shichong.spring6.dao.UserDao;
import org.springframework.stereotype.Repository;

/**
 * @Author: shichong1008@outlook.com
 * @Description: TODO
 * @DateTime: 2023/12/21 9:45
 **/
@Repository
public class UserDaoByOracle implements UserDao {
    @Override
    public void save() {
        System.out.println("oracle正在保存用户信息");
    }
}
