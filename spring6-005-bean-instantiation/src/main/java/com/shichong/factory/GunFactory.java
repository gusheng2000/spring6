package com.shichong.factory;

import com.shichong.bean.Gun;

/**
 * @Author sc
 * @ClassName GUnFactory
 * @Description class function:
 * @Date 2023/12/17 14:18:33
 **/
public class GunFactory {
    public Gun get() {
        return new Gun();
    }
}
