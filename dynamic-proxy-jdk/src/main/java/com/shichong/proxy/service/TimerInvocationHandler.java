package com.shichong.proxy.service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author: shichong1008@outlook.com
 * @Description: 负责计时的调用处理器
 * @DateTime: 2023/12/21 11:50
 **/
public class TimerInvocationHandler implements InvocationHandler {
    private Object target;

    public TimerInvocationHandler(Object target) {
        this.target = target;
    }

    /*
    1.为什么强行要求你必须实现InvocationHandler接口？
        因为一个类实现接口就必须实现接口中的方法。
        以下这个方法必须是invoke(),因为JDK在底层调用invoke()方法的程序己经提前写好了。
            注意：invoke方法不是我门程序员负责调用的，是JDK负责调用的。
    2.invoke方法什么时候被调用呢？
        当代理对象调用代理方法的时候，注册在InvocationHandler调用处理器当中的invoke()方法被调用。
    */
    /*

     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        long begin = System.currentTimeMillis();
        Object invoke = method.invoke(target, args);
        long end = System.currentTimeMillis();
        System.out.println("耗时"+ (end-begin) + "毫秒");
        //目标对象的代理方法的返回值要返回
        return invoke;
    }
}
