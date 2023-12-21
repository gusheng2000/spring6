package org.shichong.spring6.service;

import jakarta.annotation.Resource;
import org.shichong.spring6.dao.StudentDao;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * @Author: shichong1008@outlook.com
 * @Description: TODO
 * @DateTime: 2023/12/21 10:07
 **/
@Service
public class StudentService {
    /**
     * resource注解只能用在属性和方法上
     */
    @Resource
    private StudentDao studentDao;

    public void saveStudent() {
        studentDao.save();
    }
}
