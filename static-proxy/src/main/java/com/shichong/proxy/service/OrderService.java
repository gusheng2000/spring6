package com.shichong.proxy.service;

/**
 * @Author: shichong1008@outlook.com
 * @Description: 订单业务接口
 * @DateTime: 2023/12/21 10:27
 **/
public interface OrderService {
    /**
     * 生成订单
     */
    void generate();
    /**
     * 修改订单信息
     */
    void modify();

    /**
     * 查看订单详情
     */
    void detail();
}
