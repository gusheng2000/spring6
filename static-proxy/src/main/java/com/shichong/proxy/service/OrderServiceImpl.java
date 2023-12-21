package com.shichong.proxy.service;

/**
 * @Author: shichong1008@outlook.com
 * @Description: TODO
 * @DateTime: 2023/12/21 10:29
 **/
public class OrderServiceImpl implements OrderService  { //目标对象

    /**
     * 项目经理提出一个需求，要统计所有业务接口中的每个方法的执行时间
     * idea A： 采用硬编码的方式来处理   在么成儿方法中直接修改 添加统计实践的代码
     *          缺点： a：不满足OCP原则
     *                b: 代码没有得到复用 （相同的代码逻辑有很多）
     * idea B: 编写业务类的子类，子类对业务类的方法进行重写
     *             缺点：
     *                a: 虽然解决了ocp原则，但是耦合度非常高，采用了继承的方式，继承关系是一种耦合度非常高的的方式
     *                b：代码没有得到复用，每个方法还是有很多相同的方法
     *  idea C： 代理模式-->静态代理
     *          优点： 1.解决OCP问题   2.采用代理模式的has a 大大降低了耦合度
     *          缺点:
     *                  a:导致类的数量急剧增加  （每个业务都要有代理类，一百个业务类，要有一百个代理类）
     *                  如何解决？
     *                  ！ 代理模式--->动态代理  采用字节码生成技术
     *  idea D： 代理模式-->动态代理  （在程序运行阶段，在内存中动态生成代理类，被称为动态代理，目的是为了减少代理类的数量。解决代码复用的问题。）
     *  实现方式：
     *          D1: Jdk动态代理   java.lang.reflect.Proxy 只能使用接口
     *          D2: CJLIB 动态代理
     *          D3: Javassist
     */

    @Override
    public void generate() { //目标方法
        extracted();
        System.out.println("订单以生成");
    }


    @Override
    public void modify() {
        extracted();
        System.out.println("订单已修改");
    }

    @Override
    public void detail() {
        extracted();
        System.out.println("请看订单详情");
    }

    private static void extracted() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
