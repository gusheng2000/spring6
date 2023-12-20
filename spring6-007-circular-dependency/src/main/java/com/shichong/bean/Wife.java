package com.shichong.bean;

/**
 * @Author sc
 * @ClassName Wife
 * @Description class function:
 * @Date 2023/12/18 21:19:32
 **/
public class Wife {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private HusBand husBand;


    @Override
    public String toString() {
        return "Wife{" +
                "husBand=" + husBand.getName() +
                ", name='" + name + '\'' +
                '}';
    }

    public void setHusBand(HusBand husBand) {
        this.husBand = husBand;
    }
}
