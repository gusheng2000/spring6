package com.shichong.service.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Author: shichong1008@outlook.com
 * @Description: 全注解开发
 * @DateTime: 2023/12/25 13:52
 **/
@Configuration
@ComponentScan("com.shichong.service")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AnnotationConfig {
}
