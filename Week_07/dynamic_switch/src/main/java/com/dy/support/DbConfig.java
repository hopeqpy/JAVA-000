package com.dy.support;

import com.dy.config.Route;
import com.dy.enums.DbType;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: JAVA-000
 * @description:
 * @author: qpy
 */
@Configuration
public class DbConfig {

    /**
     * 写库
     * @return
     */
    @Bean
    @ConfigurationProperties("spring.datasource.master")
    public DataSource masterDataSource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * 读库1
     * @return
     */
    @Bean
    @ConfigurationProperties("spring.datasource.slave1")
    public DataSource slave1DataSource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * 读库2
     * @return
     */
    @Bean
    @ConfigurationProperties("spring.datasource.slave2")
    public DataSource slave2DataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public DataSource myRoutingDataSource(@Qualifier("masterDataSource") DataSource masterDataSource,
                                          @Qualifier("slave1DataSource") DataSource slave1DataSource,
                                          @Qualifier("slave2DataSource") DataSource slave2DataSource) {
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put( DbType.MASTER, masterDataSource);
        targetDataSources.put(DbType.SLAVE1, slave1DataSource);
        targetDataSources.put(DbType.SLAVE2, slave2DataSource);
        Route route = new Route();
        route.setDefaultTargetDataSource(masterDataSource);
        route.setTargetDataSources(targetDataSources);
        return route;
    }

}
