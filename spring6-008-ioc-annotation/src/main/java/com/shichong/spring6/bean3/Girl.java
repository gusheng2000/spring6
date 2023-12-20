package com.shichong.spring6.bean3;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

/**
 * @Author sc
 * @ClassName Girl
 * @Description class function:
 * @Date 2023/12/20 22:22:17
 **/
@Repository
public class Girl {
    private String name;
    private String email;
    private int age;


    public Girl(@Value("dadas@email.com") String email) {
        this.email = email;
    }



    @Value("shichong")
    public void setName(String name) {
        this.name = name;
    }
//    @Value("20")
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
