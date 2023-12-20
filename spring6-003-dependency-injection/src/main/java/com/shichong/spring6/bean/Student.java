package com.shichong.spring6.bean;

/**
 * @Author sc
 * @ClassName Student
 * @Description class function:
 * @Date 2023/12/15 22:09:54
 **/
public class Student {
    private String name;

    private Clazz clazz;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", clazz=" + clazz +
                '}';
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Clazz getClazz() {
        return clazz;
    }
}
