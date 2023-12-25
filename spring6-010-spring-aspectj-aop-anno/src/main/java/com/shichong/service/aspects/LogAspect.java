package com.shichong.service.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


/**
 * @Author: shichong1008@outlook.com
 * @Description: 切面类
 * @DateTime: 2023/12/25 10:40
 **/
@Component
@Aspect
public class LogAspect {//切面

    //切面=切点+通知
    //通知就是增强的方法
    @Before("execution(* com.shichong.service.UserService.*(..))")
    public void beforeAdvice() {
        System.out.println("前置通知，");
    }

    /**
     * 环绕通知
     * @param joinPoint
     */
    @Around("execution(* com.shichong.service.UserService.*(..))")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕通知开始");
        joinPoint.proceed();
        System.out.println("环绕通知结束");
    }


    @AfterReturning("execution(* com.shichong.service.UserService.*(..))")
    public void afterReturning(JoinPoint joinPoint) throws Throwable {
        System.out.println("后置通知");
    }
    @After("execution(* com.shichong.service.UserService.*(..))")
    public void after(){
        System.out.println("最终通知");
    }

    @AfterThrowing("execution(* com.shichong.service.UserService.*(..))")
    public void afterThrowing(){
        System.out.println("异常通知");
    }
}
