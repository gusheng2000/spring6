package com.shichong.factory;

import com.shichong.bean.Star;

/**
 * 简单工厂模式中的工厂角色 星工厂
 *
 * @Author sc
 * @ClassName StarFactory
 * @Description class function:
 * @Date 2023/12/17 14:04:27
 **/
public class StarFactory {
    //工厂内有一个静态方法
    //简单工厂方法又叫做 静态工厂方法模式
    public static Star createStar() {

        return new Star();
    }
}
