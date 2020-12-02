package com.dy.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @program: JAVA-000
 * @description: 路由
 * @author: qpy
 */
public class Route extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DbContext.get();
    }
}
