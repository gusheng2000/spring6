package com.shichong.service.aspects;

import cn.hutool.core.util.ClassUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.aop.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @Author: shichong1008@outlook.com
 * @Description: TODO
 * @DateTime: 2023/12/25 14:01
 **/
@Component
@Aspect
public class ScAspect {

    /**
     * 修改接口中参数的部分字段
     * @param joinPoint
     * @throws Exception
     */
    @Before("execution(public String com.shichong.service.OrderService.*(..))")
    public void before(JoinPoint joinPoint) throws Exception {
        Object[] args = joinPoint.getArgs();

        for (Object arg : args) {
            Class<?> aClass = arg.getClass();
            Method setCreateTime = aClass.getDeclaredMethod("setCreateTime", LocalDateTime.class);
            if (setCreateTime != null) {
                setCreateTime.invoke(arg, LocalDateTime.now());
            }

            Method getOrderName = aClass.getDeclaredMethod("setOrderName", String.class);

            if (getOrderName != null) {
                getOrderName.invoke(arg, "OrderName被我通过反射篡改了");
            }
        }
    }
    //通过自定义注解代替切点表达式 修改更新时间
    @Before("@annotation(com.shichong.service.annotation.Sc)")
    public void beforeByAnnotation(JoinPoint joinPoint) throws Exception {
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            Class<?> aClass = arg.getClass();
            Method setUpdateTime = aClass.getDeclaredMethod("setUpdateTime", LocalDateTime.class);
            if (setUpdateTime != null){
                setUpdateTime.invoke(arg, LocalDateTime.now());
            }
        }
    }
}
