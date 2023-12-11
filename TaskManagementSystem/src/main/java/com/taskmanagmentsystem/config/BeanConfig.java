package com.taskmanagmentsystem.config;

import org.apache.tomcat.jdbc.pool.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.stereotype.Component;

@Component

public class BeanConfig {
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.tomcat")
    public DataSource getDatasource() {
        return new DataSource();
    }


@Bean
    PasswordEncoder getPasswordEncoder(){
        return new Pbkdf2PasswordEncoder();
}
    }

