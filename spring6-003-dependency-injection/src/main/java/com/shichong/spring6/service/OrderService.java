package com.shichong.spring6.service;

import com.shichong.spring6.dao.OrderDao;

/**
 * @Author sc
 * @ClassName OrderService
 * @Description class function:
 * @Date 2023/12/16 16:42:48
 **/
public class OrderService {
    private OrderDao orderDao;

    public void insert() {
        orderDao.insert();
    }

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }
}