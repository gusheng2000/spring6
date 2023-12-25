package com.shichong.service.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Author: shichong1008@outlook.com
 * @Description: 测试切面的优先级
 * @DateTime: 2023/12/25 13:41
 **/
@Component
@Aspect
@Order(1)//可以使用@Order注解来标识切面类，为@Order注解的value指定一个整数型的数字，数字越小，优先级越高。
public class OrderAspect {
    /*巡行结果
        my环绕通知开始
        my前置通知
        环绕通知开始
        前置通知，
        系统正在验证身份
        后置通知
        最终通知
        环绕通知结束
        my后置通知
        my最终通知
        my环绕通知结束
    * */
    //优化 切点表达式重复修改麻烦
    @Pointcut("execution(* com.shichong.service.UserService.*(..))")
    public void pointcut() {
    }
    @Before("pointcut()")
    public void beforeAdvice() {
        System.out.println("my前置通知");
    }
    /**
     * 环绕通知
     *
     * @param joinPoint
     */
    @Around("pointcut()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("my环绕通知开始");
        joinPoint.proceed();
        System.out.println("my环绕通知结束");
    }


    @AfterReturning("pointcut()")
    public void afterReturning(JoinPoint joinPoint) throws Throwable {
        System.out.println("my后置通知");
    }

    @After("pointcut()")
    public void after() {
        System.out.println("my最终通知");
    }

    @AfterThrowing("pointcut()")
    public void afterThrowing() {
        System.out.println("my异常通知");
    }

}
