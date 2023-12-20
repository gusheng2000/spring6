package com.shichong.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @Author: shichong1008@outlook.com
 * @Description: TODO
 * @DateTime: 2023/12/20 14:27
 **/
public class Test {
    public static void main(String[] args) throws Exception {

/* 传统方式
   SomeService someService = new SomeService();

        someService.doSome();
        String s = someService.doSome("李四");
        System.out.println(s+"\n");
        String s1 = someService.doSome("李四", 22);
        System.out.println(s1+"\n");*/

        Class<?> aClass = Class.forName("com.shichong.reflect.SomeService");
        Method doSome = aClass.getDeclaredMethod("doSome", String.class);
        //发弄和获取对象 方式一
//        Constructor<?> constructor = aClass.getDeclaredConstructor();
//        Object o = constructor.newInstance();
        //发弄和获取对象 方式二
        Object o1 = aClass.newInstance();
        //调用方法
        Object invoke = doSome.invoke(o1, "石冲");
        System.out.println(invoke);
    }
}
