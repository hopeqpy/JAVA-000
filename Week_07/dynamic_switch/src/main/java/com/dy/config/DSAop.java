package com.dy.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @program: JAVA-000
 * @description:
 * @author: qpy
 */
@Aspect
@Component
public class DSAop {

    /**
     * 只读：
     * 不是Master注解的对象或方法  && select开头的方法  ||  get开头的方法
     */
    @Pointcut("!@annotation(com.dy.annotation.Master) " +
            "&& (execution(* com.dy.service..*.select*(..)) " +
            "|| execution(* com.dy.service..*.get*(..)))")
    public void readPointcut() {

    }

    /**
     * 写：
     * Master注解的对象或方法 || insert开头的方法  ||  add开头的方法 || update开头的方法
     * || edlt开头的方法 || delete开头的方法 || remove开头的方法
     */
    @Pointcut("@annotation(com.dy.annotation.Master) " +
            "|| execution(* com.dy.service..*.insert*(..)) " +
            "|| execution(* com.dy.service..*.add*(..)) " +
            "|| execution(* com.dy.service..*.update*(..)) " +
            "|| execution(* com.dy.service..*.edit*(..)) " +
            "|| execution(* com.dy.service..*.delete*(..)) " +
            "|| execution(* com.dy..*.remove*(..))")
    public void writePointcut() {

    }

    @Before("readPointcut()")
    public void read() {
        DbContext.slave();
    }

    @Before("writePointcut()")
    public void write() {
        DbContext.master();
    }
}
