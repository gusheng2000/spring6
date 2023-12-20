package com.shichong.spring6.bean;

/**
 * @Author sc
 * @ClassName Clazz
 * @Description class function:
 * @Date 2023/12/15 22:09:09
 **/
public class Clazz {
    private String name;

    @Override
    public String toString() {
        return "Clazz{" +
                "name='" + name + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }
}
