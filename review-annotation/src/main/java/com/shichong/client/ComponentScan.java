package com.shichong.client;

import com.shichong.annotation.Component;

import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author sc
 * @ClassName ComponentScan
 * @Description class function:
 * @Date 2023/12/20 20:57:25
 **/
public class ComponentScan {
    public static void main(String[] args) {
         Map<String, Object> map=new ConcurrentHashMap<>(500);

        //扫描注定包路径下的类只要被@component 修饰的类 实例化该对象，存入map
        String basePackages = "com.shichong.bean";
        //.在正则表达式中代表任意字符，这里的“.”要使用”\."来表示
        String packagesPath = basePackages.replaceAll("\\.", "/");
        System.out.println(packagesPath);
        URL resource = ClassLoader.getSystemClassLoader().getResource(packagesPath);
        //绝对路径
        String path = resource.getPath();
        //获取绝对路径下的所有文件
        File file = new File(path);
        File[] files = file.listFiles();
        Arrays.stream(files).forEach(f -> {


            try {
                //System.out.println(f.getName());
                //System.out.println(f.getName().split("\\.")[0]);
                //System.out.println(f.getName().split("\\.")[0] );
                String className = basePackages + "." + f.getName().split("\\.")[0];
                //System.out.println(className);
                Class<?> aClass = Class.forName(className);
                //判断类上面有没有Component注解
                boolean annotationPresent = aClass.isAnnotationPresent(Component.class);
                if (annotationPresent) {

                    //获取注解
                    Component annotation = aClass.getAnnotation(Component.class);
                    Object obj = aClass.newInstance();
                    map.put(annotation.value(), obj);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        System.out.println(map);
    }
}
