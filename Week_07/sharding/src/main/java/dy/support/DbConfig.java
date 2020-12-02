package dy.support;


import dy.enums.DbType;
import io.shardingjdbc.core.api.MasterSlaveDataSourceFactory;
import io.shardingjdbc.core.api.config.MasterSlaveRuleConfiguration;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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
    @ConfigurationProperties("spring.shardingsphere.datasource.master")
    public DataSource masterDataSource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * 读库1
     * @return
     */
    @Bean
    @ConfigurationProperties("spring.shardingsphere.datasource.slave1")
    public DataSource slave1DataSource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * 读库2
     * @return
     */
    @Bean
    @ConfigurationProperties("spring.shardingsphere.datasource.slave2")
    public DataSource slave2DataSource() {
        return DataSourceBuilder.create().build();
    }

    @SneakyThrows
    @Bean
    public DataSource myRoutingDataSource(@Qualifier("masterDataSource") DataSource masterDataSource,
                                          @Qualifier("slave1DataSource") DataSource slave1DataSource,
                                          @Qualifier("slave2DataSource") DataSource slave2DataSource) {
        Map<String, DataSource> targetDataSources = new HashMap<>();
        targetDataSources.put( DbType.MASTER.name(), masterDataSource);
        targetDataSources.put(DbType.SLAVE1.name(), slave1DataSource);
        targetDataSources.put(DbType.SLAVE2.name(), slave2DataSource);
        MasterSlaveRuleConfiguration masterSlaveRuleConfig = new MasterSlaveRuleConfiguration();
        masterSlaveRuleConfig.setName("my_rt");
        masterSlaveRuleConfig.setMasterDataSourceName("masterDataSource");
        masterSlaveRuleConfig.getSlaveDataSourceNames().add("slave1DataSource");
        masterSlaveRuleConfig.getSlaveDataSourceNames().add("slave2DataSource");

        final DataSource dataSource = MasterSlaveDataSourceFactory.createDataSource(targetDataSources, masterSlaveRuleConfig, new HashMap<>());
        return dataSource;
    }

}
