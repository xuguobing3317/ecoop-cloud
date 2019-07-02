package com.ecoop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;

/**
 * @ClassName PidDataSourceConfig
 * @Description PID数据源配置
 * @Author crazy
 * @Date 2019-07-01 16:53
 * @Version 1.0
 **/
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "pidEntityManagerFactory",
        transactionManagerRef = "pidTransactionManager",
        basePackages = {"com.ecoop.repository.pid"})
public class PidDataSourceConfig {

    @Autowired
    @Qualifier("pidDataSource")
    private DataSource pidDataSource;

    @Autowired
    private JpaProperties jpaProperties;

    @Autowired
    private HibernateProperties hibernateProperties;


    @Primary
    @Bean("pidEntityManager")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return pidEntityManagerFactory(builder).getObject().createEntityManager();
    }


    @Primary
    @Bean(name = "pidEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean pidEntityManagerFactory(
            EntityManagerFactoryBuilder builder) {
        Map<String, Object> properties = hibernateProperties.determineHibernateProperties(
                jpaProperties.getProperties(), new HibernateSettings());
        return builder
                .dataSource(pidDataSource)
                .properties(properties)
                .packages("com.ecoop.entity.pid")
                .persistenceUnit("pidPersistenceUnit")
                .build();
    }

    @Primary
    @Bean(name = "pidTransactionManager")
    public PlatformTransactionManager pidTransactionManager(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(pidEntityManagerFactory(builder).getObject());
    }


}
