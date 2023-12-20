package com.shichong.reflect;

/**
 * @Author: shichong1008@outlook.com
 * @Description: TODO
 * @DateTime: 2023/12/20 14:24
 **/
public class SomeService {
    public void doSome() {
        System.out.println("public void doSome()执行");
    }

    public String doSome(String s) {
        System.out.println("public void doSome(String s)执行");
        return s;
    }

    public String doSome(String s, int i) {
        System.out.println("public String doSome(String s ,int i)执行");
        return s + i;
    }
}
