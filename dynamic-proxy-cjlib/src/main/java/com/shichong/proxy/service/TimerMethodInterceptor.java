package com.shichong.proxy.service;




import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author: shichong1008@outlook.com
 * @Description: TODO
 * @DateTime: 2023/12/21 13:42
 **/
public class TimerMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {

        long begin= System.currentTimeMillis();

        Object value = proxy.invokeSuper(obj, args);
        long end= System.currentTimeMillis();
        System.out.println("耗时"+(end-begin)+" 毫秒");

        return value;
    }
}
