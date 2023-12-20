package org.myspringframework.core;

/**
 * @Author: shichong1008@outlook.com
 * @Description: TODO
 * @DateTime: 2023/12/20 15:13
 **/
public interface ApplicationContext {
    /**
     * 通过bean的name获取bean
     * @param beanName
     * @return
     */
    Object getBean(String beanName);
}
