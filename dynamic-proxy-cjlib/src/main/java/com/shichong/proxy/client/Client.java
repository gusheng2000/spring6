package com.shichong.proxy.client;

import com.shichong.proxy.service.TimerMethodInterceptor;
import com.shichong.proxy.service.UserService;
import net.sf.cglib.proxy.Enhancer;


/**
 * @Author: shichong1008@outlook.com
 * @Description: TODO
 * @DateTime: 2023/12/21 13:36
 **/
public class Client {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        //设置代理的类
        enhancer.setSuperclass(UserService.class);
        enhancer.setCallback(new TimerMethodInterceptor());

        UserService service = (UserService)enhancer.create();
        System.out.println(service);
//com.shichong.proxy.service.UserService$$EnhancerByCGLIB$$abebec19@75412c2f
        boolean success = service.login("admin", "password");
        System.out.println(success?"成功": "失败");
    }
}
