package com.shichong.bean;

import java.util.Date;

/**
 * @Author sc
 * @ClassName Person
 * @Description class function:
 * @Date 2023/12/17 14:27:32
 **/
public class Person {
    public Date birthday;

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Person() {
        System.out.println("Person的无参构造方法执行");
    }
}
