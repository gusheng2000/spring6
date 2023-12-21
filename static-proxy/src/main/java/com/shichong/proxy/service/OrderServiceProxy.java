package com.shichong.proxy.service;

/**
 * @Author: shichong1008@outlook.com
 * @Description: TODO
 * @DateTime: 2023/12/21 11:05
 **/
//代理对象，（代理对象和目标对象要有一样的行为，就要实现同一个接口或者同一些接口）
//客户端在使用代理对象的时候就像在使用目标对象一样。
public class OrderServiceProxy implements OrderService {

    //这里代理对象和目标对象的关系是关联关系   之前的继承关系是泛化关系
    private OrderService target;
    //创建代理对象的时候 传入一个目标对象给代理对象
    public OrderServiceProxy(OrderService target) {
        this.target = target;
    }

    @Override
    public void generate() {//代理方法
        long begin = System.currentTimeMillis();
        target.generate();
        long end = System.currentTimeMillis();
        System.out.println("耗时" + (end - begin) + "毫秒");

    }

    @Override
    public void modify() {
        long begin = System.currentTimeMillis();
        target.modify();
        long end = System.currentTimeMillis();
        System.out.println("耗时" + (end - begin) + "毫秒");
    }

    @Override
    public void detail() {
        long begin = System.currentTimeMillis();
        target.detail();
        long end = System.currentTimeMillis();
        System.out.println("耗时" + (end - begin) + "毫秒");
    }
}
