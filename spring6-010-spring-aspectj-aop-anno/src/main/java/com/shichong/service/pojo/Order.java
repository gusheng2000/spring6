package com.shichong.service.pojo;

import java.time.LocalDateTime;

/**
 * @Author: shichong1008@outlook.com
 * @Description: TODO
 * @DateTime: 2023/12/25 14:51
 **/
public class Order {
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private String orderNo;
    private String orderName;

    @Override
    public String toString() {
        return "Order{" +
                "createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", orderNo='" + orderNo + '\'' +
                ", orderName='" + orderName + '\'' +
                '}';
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public Order() {
    }
    public Order(String orderNo, String orderName) {
        this.orderNo = orderNo;
        this.orderName = orderName;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
}
