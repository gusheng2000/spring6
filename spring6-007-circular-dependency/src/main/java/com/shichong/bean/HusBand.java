package com.shichong.bean;



/**
 * @Author sc
 * @ClassName HusBand
 * @Description class function:
 * @Date 2023/12/18 21:19:51
 **/
public class HusBand {
    private Wife wife;
    private String name;

    public String getName() {
        return name;
    }

    public void setWife(Wife wife) {
        this.wife = wife;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "HusBand{" +
                "wife=" + wife.getName() +
                ", name='" + name + '\'' +
                '}';
    }
}
