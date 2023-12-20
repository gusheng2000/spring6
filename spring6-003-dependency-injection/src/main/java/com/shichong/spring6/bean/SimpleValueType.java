package com.shichong.spring6.bean;

import java.util.Date;

/**
 * @Author sc
 * @ClassName SimpleValueType
 * @Description class function:
 * @Date 2023/12/15 21:37:22
 **/
public class SimpleValueType {
    private int int1;
    private Integer int2;
    private long long1;
    private Long long2;
    private short short1;
    private Short short2;

    private boolean boolean1;
    private Boolean boolean2;
    private Enum e2;

    private Date birthday;
    private Class aClass;

    @Override
    public String toString() {
        return "SimpleValueType{" +
                "int1=" + int1 +
                ", int2=" + int2 +
                ", long1=" + long1 +
                ", long2=" + long2 +
                ", short1=" + short1 +
                ", short2=" + short2 +
                ", boolean1=" + boolean1 +
                ", boolean2=" + boolean2 +
                ", e2=" + e2 +
                ", birthday=" + birthday +
                '}';
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setInt1(int int1) {
        this.int1 = int1;
    }

    public void setInt2(Integer int2) {
        this.int2 = int2;
    }

    public void setLong1(long long1) {
        this.long1 = long1;
    }

    public void setLong2(Long long2) {
        this.long2 = long2;
    }

    public void setShort1(short short1) {
        this.short1 = short1;
    }

    public void setShort2(Short short2) {
        this.short2 = short2;
    }

    public void setBoolean1(boolean boolean1) {
        this.boolean1 = boolean1;
    }

    public void setBoolean2(Boolean boolean2) {
        this.boolean2 = boolean2;
    }

    public void setE2(Enum e2) {
        this.e2 = e2;
    }

    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }

}
