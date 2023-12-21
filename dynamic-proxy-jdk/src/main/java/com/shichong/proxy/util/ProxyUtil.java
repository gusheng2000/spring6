package com.shichong.proxy.util;

import com.shichong.proxy.service.OrderService;
import com.shichong.proxy.service.TimerInvocationHandler;

import java.lang.reflect.Proxy;

/**
 * @Author: shichong1008@outlook.com
 * @Description: TODO
 * @DateTime: 2023/12/21 13:14
 **/
public class ProxyUtil {
    public static Object newProxyInstance(Object target){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new TimerInvocationHandler(target));//调用代
    }
}
