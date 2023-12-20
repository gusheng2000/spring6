package com.shichong.simple.factory;

/**
 * @Author sc
 * @ClassName WeaponFactory
 * @Description class function:
 * @Date 2023/12/17 13:20:45
 **/
public class WeaponFactory {

    /**
     * 静态方法 要获取什么产品 看你传入什么参数
     * @param weaponName
     * @return
     */
    public static Weapon createWeapon(String weaponName) {
        if ("TANK".equals(weaponName)) {
            return new Tank();
        } else if ("DAGGER".equals(weaponName)) {
            return new Dagger();
        } else if ("FIGHTER".equals(weaponName)) {
            return new Fighter();
        } else {
            throw new RuntimeException("没有这个武器");
        }
    }


}
