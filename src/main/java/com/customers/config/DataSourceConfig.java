package com.customers.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;

//@Configuration
//public class DataSourceConfig {
//
//    @Bean
//    @Qualifier("default")
//    @ConfigurationProperties(prefix="spring.datasource")
//    public DataSource defaultDataSource(){
//        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//        return dataSourceBuilder.build();
//    }
//
//    @Bean
//    @Primary
//    @Scope("singleton")
//    public AbstractRoutingDataSource routingDataSource(@Autowired @Qualifier("default") DataSource defaultDataSource){
//        RoutingDataSource routingDataSource = new RoutingDataSource();
//        routingDataSource.addDataSource(RoutingDataSource.DEFAULT, defaultDataSource);
//        routingDataSource.setDefaultTargetDataSource(defaultDataSource);
//        return routingDataSource;
//    }
//
//}
