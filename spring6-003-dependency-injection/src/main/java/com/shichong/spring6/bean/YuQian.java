package com.shichong.spring6.bean;

import java.util.Arrays;

/**
 * @Author sc
 * @ClassName YuQian
 * @Description class function:
 * @Date 2023/12/15 22:20:59
 **/
public class YuQian {
    public String[] aiHaos;

    @Override
    public String toString() {
        return "YuQian{" +
                "aiHaos=" + Arrays.toString(aiHaos) +
                '}';
    }

    public void setAiHaos(String[] aiHaos) {
        this.aiHaos = aiHaos;
    }
}
