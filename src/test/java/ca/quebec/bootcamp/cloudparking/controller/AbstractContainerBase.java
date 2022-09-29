package ca.quebec.bootcamp.cloudparking.controller;

import org.testcontainers.containers.MySQLContainer;

public class AbstractContainerBase {

    static final MySQLContainer MY_SQL_CONTAINER;

    static {
        MY_SQL_CONTAINER = new MySQLContainer("mysql:5.7");
        MY_SQL_CONTAINER.start();
        System.setProperty("spring.datasource.url", MY_SQL_CONTAINER.getJdbcUrl());
        System.setProperty("spring.datasource.username", MY_SQL_CONTAINER.getUsername());
        System.setProperty("spring.datasource.password", MY_SQL_CONTAINER.getPassword());
    }
}