package com.shichong.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Author: shichong1008@outlook.com
 * @Description: TODO
 * @DateTime: 2023/12/20 14:48
 **/
public class Test4 {
    public static void main(String[] args) throws Exception {
        /*
        使用反射机制 调用user的setName setAge
        * */
        Class<User> userClass = User.class;
        User user = userClass.newInstance();

        //获取属性
        Field name = userClass.getDeclaredField("name");
        Class<?> type = name.getType();
        Field age = userClass.getDeclaredField("age");
        Class<?> ageType = age.getType();
        //获取方法
        Method setName = userClass.getDeclaredMethod("setName",type);
        Method setAge = userClass.getDeclaredMethod("setAge", ageType);
        setName.invoke(user,"石冲");
        setAge.invoke(user,12);

        System.out.println(user);
    }
}
