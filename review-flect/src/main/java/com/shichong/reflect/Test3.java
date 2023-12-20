package com.shichong.reflect;

import java.lang.reflect.Method;

/**
 * @Author: shichong1008@outlook.com
 * @Description: TODO
 * @DateTime: 2023/12/20 14:27
 **/
public class Test3 {
    public static void main(String[] args) throws Exception {
        //获取类
        Class<SomeService> aClass = SomeService.class;
        //获取对象
        SomeService instance = aClass.newInstance();
        //获取方法
        Method doSome = aClass.getDeclaredMethod("doSome", String.class, int.class);
        //执行方法
        Object value= doSome.invoke(instance, "石冲 ", 22);
        System.out.println(value);
    }
}
