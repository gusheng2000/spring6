package com.shichong.bean;

/**
 * Bean的生命周期按照粗略的五步的活：
 * 第一步：实例化Bean(调用无参数构造方法。)
 * 第二步：给Bean属性赋值（凋用set方法。）
 * 第步：初始化Bean(会调用Bean的nit方法。注意：这个init方法需要自己写，自己配。)
 * 第四步：使用Bean
 * 第五步：销毁Bean
 * (会调用Bean的destroy.方法。注意：这个destroy方法需要自己写，自己配。)
 * @Author sc
 * @ClassName User
 * @Description class function:
 * @Date 2023/12/18 18:44:55
 **/
public class User {
    private String name;

    public void setName(String name) {
        this.name = name;
        System.out.println("第二步：给对象的属性赋值");
    }

    public User() {
        System.out.println("第一步：无参构造方法执行");
    }
    public void init(){
        System.out.println("第三步：初始化方法执行");
    }
    public void destroy(){
        System.out.println("第五步：销毁方法执行");
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
