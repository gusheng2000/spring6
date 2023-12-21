package com.shichong.proxy.client;

import com.shichong.proxy.service.OrderService;
import com.shichong.proxy.service.OrderServiceImpl;
import com.shichong.proxy.service.TimerInvocationHandler;
import com.shichong.proxy.util.ProxyUtil;

import java.lang.reflect.Proxy;

/**
 * @Author: shichong1008@outlook.com
 * @Description: TODO
 * @DateTime: 2023/12/21 11:34
 **/
public class Client {
    public static void main(String[] args) {
        //创建目标对象
        OrderServiceImpl target = new OrderServiceImpl();
        //创建代理对象
        /*
            newProxyInstance: 创建代理对象
            newProxyInstance()方法做了两件事
              一，在内存中动态的生成了代理类的字节码class
              二， new 出代理对象  通过字节码 实例化代理对象
            参数
            ClassLoader – the class loader to define the proxy class
                        类丽载器。这个类加载器有什么用呢？
                                 在内存当中生成的字节码也是cLāSS文件，要执行也得先加载到内存当中。加载类就需要类加载器。所以这里需要指定类加载器。
                                  并且JDK要求，目标类的类加载器必须和代理类的类加载器使用同一个。
            Class<?>[] – the list of interfaces for the proxy class to implement
                目标类实现的接口
            Class<?>[] – the invocation handler to dispatch method invocations to
                        调用处理器 是一个接口
                        调用处理器的代码是我们要增强的代码
         */
        OrderService o = (OrderService)ProxyUtil.newProxyInstance(target);
        o.detail();
        String name = o.getname();
        System.out.println(name);
    }
}
