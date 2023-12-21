package com.shichong.proxy.service;

/**
 * @Author: shichong1008@outlook.com
 * @Description: TODO
 * @DateTime: 2023/12/21 13:32
 **/
public class UserService {

    public  boolean login(String username, String password) {
        System.out.println("正在验证身份");
        if ("admin".equals(username) && "password".equals(password)) {
            return true;
        }
        return false;
    }

    public void logout() {
        System.out.println("系统正在退出");
    }
}
