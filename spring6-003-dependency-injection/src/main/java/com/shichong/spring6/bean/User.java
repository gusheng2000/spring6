package com.shichong.spring6.bean;

/**
 * @Author sc
 * @ClassName User
 * @Description class function:
 * @Date 2023/12/15 21:18:25
 **/
public class User {
    private String userName;
    private String password;
    private int age;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                '}';
    }
}
