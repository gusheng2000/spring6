package com.shichong.simple.factory;

/**
 * @Author sc
 * @ClassName Client
 * @Description class function:
 * @Date 2023/12/17 13:24:45
 **/
public class Client {
    public static void main(String[] args) {
        //需要坦克
        //对于我客户端来说，坦克的生产细节，我不需要关心，我只需要向工厂索要即可。
        //简单工厂模式达到了什么呢？职责分离。客户端不需要关心产品的生产细节。
        //客户端只负责消费。工厂类负责生产。一个负责生产，一个负责消费。生产者和消费者分离了。这就是简单工厂模式的作用。
        Weapon tank = WeaponFactory.createWeapon("TANK");
        tank.attack();
        //匕首

        Weapon dagger = WeaponFactory.createWeapon("DAGGER");
        dagger.attack();
        //战斗机
        Weapon fighter = WeaponFactory.createWeapon("FIGHTER");
        fighter.attack();
    }
}
