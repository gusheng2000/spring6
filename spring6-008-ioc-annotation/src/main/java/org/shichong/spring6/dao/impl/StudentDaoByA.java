package org.shichong.spring6.dao.impl;

import org.shichong.spring6.dao.StudentDao;

/**
 * @Author: shichong1008@outlook.com
 * @Description: TODO
 * @DateTime: 2023/12/21 10:06
 **/
public class StudentDaoByA implements StudentDao {
    @Override
    public void save() {
        System.out.println("Saving by A");
    }
}
