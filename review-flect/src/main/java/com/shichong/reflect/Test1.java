package com.shichong.reflect;

import java.lang.reflect.Method;

/**
 * @Author: shichong1008@outlook.com
 * @Description: TODO
 * @DateTime: 2023/12/20 14:27
 **/
public class Test1 {
    public static void main(String[] args) throws Exception {

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
