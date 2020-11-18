package config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @program: JAVA-000
 * @description:
 * @author: qpy
 */
@Configuration
public class DataSourceConfig {

    @Bean
    @Primary
    @Qualifier("dataSource")
    @ConfigurationProperties(prefix="spring.datasource" )
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().build();
    }
}
