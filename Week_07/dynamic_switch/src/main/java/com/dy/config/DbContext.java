package com.dy.config;

import com.dy.enums.DbType;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: JAVA-000
 * @description:
 * @author: qpy
 */
public class DbContext {
    private static final ThreadLocal<DbType> contextHolder = new ThreadLocal<>();
    private static final AtomicInteger counter = new AtomicInteger(-1);

    public static void set(DbType dbType) {
        contextHolder.set(dbType);
    }

    public static DbType get() {
        return contextHolder.get();
    }

    public static void master() {
        set(DbType.MASTER);
        System.out.println("切换到master");
    }

    public static void slave() {
        //  轮询
        int index = counter.getAndIncrement() % 2;
        if (counter.get() > 9999) {
            counter.set(-1);
        }
        if (index == 0) {
            set( DbType.SLAVE1);
            System.out.println("切换到slave1");
        }else {
            set(DbType.SLAVE2);
            System.out.println("切换到slave2");
        }
    }
}
