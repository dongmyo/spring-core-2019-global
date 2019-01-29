package com.nhnent.edu.spring_core.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:datasource.properties")
public class DatabaseConfig {
    @Value("${datasource.driver-class-name}")
    private String driverClassName;

    @Value("${datasource.url}")
    private String url;

    @Value("${datasource.username:sa}")
    private String username;

    @Value("${datasource.password:}")
    private String password;


    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();

        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        dataSource.setInitialSize(10);
        dataSource.setMaxTotal(10);
        dataSource.setMaxIdle(10);
        dataSource.setMinIdle(10);

        dataSource.setMaxWaitMillis(1000);

        dataSource.setTestOnBorrow(true);
        dataSource.setTestOnReturn(true);
        dataSource.setTestWhileIdle(true);

        dataSource.setTimeBetweenEvictionRunsMillis(30000);

        dataSource.setNumTestsPerEvictionRun(5);
        dataSource.setMinEvictableIdleTimeMillis(-1);
        dataSource.setValidationQuery("SELECT 0");
        dataSource.setPoolPreparedStatements(true);
        dataSource.setMaxOpenPreparedStatements(50);

        return dataSource;
    }

    @Primary
    @Bean
    public JdbcTemplate jdbcTemplate1() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
        jdbcTemplate.setResultsMapCaseInsensitive(true);

        return jdbcTemplate;
    }

    @Bean
    public JdbcTemplate jdbcTemplate2(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.setResultsMapCaseInsensitive(true);

        return jdbcTemplate;
    }

}
