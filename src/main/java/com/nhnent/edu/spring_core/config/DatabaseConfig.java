package com.nhnent.edu.spring_core.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {
    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();

        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:~/springcore;INIT=RUNSCRIPT FROM 'classpath:/script/schema.sql'");
        dataSource.setUsername("sa");
        dataSource.setPassword("");

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
