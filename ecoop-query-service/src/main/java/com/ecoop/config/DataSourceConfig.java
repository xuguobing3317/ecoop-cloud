package com.ecoop.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @ClassName DataSourceConfig
 * @Description TODO
 * @Author crazy
 * @Date 2019-07-01 23:19
 * @Version 1.0
 **/
@Configuration
public class DataSourceConfig {
    //PID数据源
    @Primary
    @Bean(name = "pidDataSourceProperties")
    @Qualifier("pidDataSourceProperties")
    @ConfigurationProperties(prefix = "spring.datasource.dbpid")
    public DataSourceProperties pidDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Primary
    @Bean(name = "pidDataSource")
    @Qualifier("pidDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.dbpid")
    public DataSource pidDataSource(@Qualifier("pidDataSourceProperties") DataSourceProperties dataSourceProperties) {
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }

    //User数据源
    @Bean(name = "userDataSourceProperties")
    @Qualifier("userDataSourceProperties")
    @ConfigurationProperties(prefix = "spring.datasource.dbuser")
    public DataSourceProperties userDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "userDataSource")
    @Qualifier("userDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.dbuser")
    public DataSource userDataSource(@Qualifier("userDataSourceProperties") DataSourceProperties dataSourceProperties) {
        return dataSourceProperties.initializeDataSourceBuilder().build();
    }

}
