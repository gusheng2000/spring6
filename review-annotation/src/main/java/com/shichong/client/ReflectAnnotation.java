package com.shichong.client;

import com.shichong.annotation.Component;

/**
 * @Author sc
 * @ClassName ReflectAnnotation
 * @Description class function:
 * @Date 2023/12/20 20:49:55
 **/
public class ReflectAnnotation {
    public static void main(String[] args) throws ClassNotFoundException {
        //通过反射机制读取注解
        Class<?> aClass = Class.forName("com.shichong.bean.User");
        String name = aClass.getSimpleName();
        System.out.println(name);
        //判断类上面的有没有注解
        if (aClass.isAnnotationPresent(Component.class)) {
            Component component = aClass.getAnnotation(Component.class);
            String value = component.value();
            System.out.println(value);
        }
    }
}
