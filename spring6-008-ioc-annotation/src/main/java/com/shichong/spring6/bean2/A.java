package com.shichong.spring6.bean2;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * @Author sc
 * @ClassName A
 * @Description class function:
 * @Date 2023/12/20 21:57:38
 **/
@Component
public class A {
    public A() {
        System.out.println("A的构造方法执行");
    }
}
@Service
class B {
    public B() {
        System.out.println("B的构造方法执行");
    }
}
@Repository
class C {
    public C() {
        System.out.println("C的构造方法执行");
    }
}
@Component
class D {
    public D() {
        System.out.println("D的构造方法执行");
    }
}
