package com.shichong.proxy.client;

import com.shichong.proxy.service.OrderServiceImpl;
import com.shichong.proxy.service.OrderServiceImplSub;
import com.shichong.proxy.service.OrderServiceProxy;

/**
 * @Author: shichong1008@outlook.com
 * @Description: TODO
 * @DateTime: 2023/12/21 10:34
 **/
public class Test {
    public static void main(String[] args) {
        //业务执行代码时间太久  要优化
        /*OrderServiceImpl service = new OrderServiceImpl();
        service.detail();
        service.generate();
        service.modify();*/

        //优化一 使用继承
        /*
            OrderServiceImpl service = new OrderServiceImplSub();
            service.detail();
            service.generate();
            service.modify();
        */
                
        //优化三 静态代理
        OrderServiceImpl target = new OrderServiceImpl();
        //创建代理类
        OrderServiceProxy proxy = new OrderServiceProxy(target);
        proxy.generate();
        proxy.detail();
        proxy.modify();
    }
}
