package com.saradha.multipledatasource.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "contactEntityManagerFactory",
        transactionManagerRef = "contactTransactionManager",
        basePackages = {"com.saradha.multipledatasource.repository.contact"}
)
public class H2DataSourceConfig {

    @Bean(name = "contactDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.contactdb")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "contactEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean
    contactEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("contactDataSource") DataSource dataSource
    ) {
        Map<String, String> additionalProperties = new HashMap<>();
        additionalProperties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        additionalProperties.put("hibernate.hbm2ddl.auto", "update");
        additionalProperties.put("spring.h2.console.enabled", "true");
        additionalProperties.put("spring.h2.console.path", "/h2_console");
        return builder
                .dataSource(dataSource)
                .packages("com.saradha.multipledatasource.model.contact")
                .persistenceUnit("contact")
                .properties(additionalProperties)
                .build();
    }

    @Bean(name = "contactTransactionManager")
    public PlatformTransactionManager contactTransactionManager(
            @Qualifier("contactEntityManagerFactory") EntityManagerFactory
                    contactEntityManagerFactory
    ) {
        return new JpaTransactionManager(contactEntityManagerFactory);
    }

}
