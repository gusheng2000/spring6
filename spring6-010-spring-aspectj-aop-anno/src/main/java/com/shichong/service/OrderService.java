package com.shichong.service;

import com.shichong.service.annotation.Sc;
import com.shichong.service.pojo.Order;
import org.springframework.stereotype.Service;

/**
 * @Author: shichong1008@outlook.com
 * @Description: TODO
 * @DateTime: 2023/12/25 14:01
 **/
@Service
public class OrderService {

    @Sc
    public String getOrder(Order order) {

        return order.toString();
    }
}