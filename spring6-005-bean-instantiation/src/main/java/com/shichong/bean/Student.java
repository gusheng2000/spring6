package com.shichong.bean;

import java.util.Date;

/**
 * @Author sc
 * @ClassName Student
 * @Description class function:
 * @Date 2023/12/17 14:55:27
 **/
public class Student {
    public Date birthday;

    @Override
    public String toString() {
        return "Student{" +
                "birthday=" + birthday +
                '}';
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
