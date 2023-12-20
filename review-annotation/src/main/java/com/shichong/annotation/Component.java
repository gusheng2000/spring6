package com.shichong.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//标识注解的注解叫做元注解
//下面的注解可以出现在类、属性上面
//@Target(value = {ElementType.TYPE,ElementType.FIELD})
//下面的注解可以出现在类上面
//@Target(value = {ElementType.TYPE})
//使用某个注解 里面的value可以省略
//@Target( {ElementType.TYPE})
//如果注解的value是数组，只有一个值大括号可以省略
@Target(ElementType.TYPE)
//@Retention是一个元注解,它标记的注解可以保留在class文件中,可以通过反射获得
@Retention(RetentionPolicy.RUNTIME)
//RetentionPolicy.CLASS,它标记的注解可以保留在class文件中,不可以通过反射获得
//@Retention(RetentionPolicy.CLASS)
//RetentionPolicy.SOURCE,只在源文件中,不可以通过反射获得
//@Retention(RetentionPolicy.SOURCE)
public @interface Component {
    //注解的属性
    String value();

    int age()default 0;

}
