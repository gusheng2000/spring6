package com.shichong.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @Author: shichong1008@outlook.com
 * @Description: TODO
 * @DateTime: 2023/12/25 10:38
 **/
@Component("userService")
public class UserService {
    public void login() {
        System.out.println("系统正在验证身份");
    }
}
