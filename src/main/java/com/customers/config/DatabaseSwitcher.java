package com.customers.config;

import lombok.RequiredArgsConstructor;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.spi.MetadataImplementor;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaUpdate;
import org.hibernate.tool.schema.TargetType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

import javax.imageio.spi.ServiceRegistry;
import javax.sql.DataSource;
import java.util.EnumSet;


//@Component
//public class DatabaseSwitcher {
//
//    private final AbstractRoutingDataSource routingDataSource;
//
//    public DatabaseSwitcher(AbstractRoutingDataSource routingDataSource) {
//        this.routingDataSource = routingDataSource;
//    }
//
//    @Value("${spring.jpa.orm}")
//    private String ormMapping;
//
//    public void applySettings(DatabaseSettings databaseSettings){
//        if (routingDataSource instanceof RoutingDataSource){
//            DataSource dataSource = DataSourceBuilder
//                    .create()
//                    .username(databaseSettings.getUserName())
//                    .url(databaseSettings.getJdbcUrl())
//                    .password(databaseSettings.getPassword())
//                    .build();
//
//            RoutingDataSource rds = (RoutingDataSource) routingDataSource;
//
//            rds.addDataSource(RoutingDataSource.NEW, dataSource);
//            rds.setKey(RoutingDataSource.NEW);
//
//            updateDDL(databaseSettings);
//
//        }
//    }
//
//    private void updateDDL(DatabaseSettings databaseSettings) {
//
//
//
//        Configuration configuration = new Configuration();
//        configuration.setProperty("hibernate.connection.password", databaseSettings.getPassword());
//        configuration.setProperty("hibernate.connection.url", databaseSettings.getJdbcUrl());
//        configuration.setProperty("hibernate.connection.username", databaseSettings.getUserName());
//        configuration.addResource(ormMapping);
//        configuration.addPackage("com.customers.domain");
//        configuration.configure();
//
//        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
//                .applySettings(configuration.getProperties()).build();
//
//
//        Metadata metadata = new MetadataSources()
//                .addResource(ormMapping)
//                .addPackage("com.customers.domain")
//                .buildMetadata(registry);
//
//        new SchemaUpdate().execute(EnumSet.of(TargetType.DATABASE), metadata, registry);
//
//    }
//}
