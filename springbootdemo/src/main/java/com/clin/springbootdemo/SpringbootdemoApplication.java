package com.clin.springbootdemo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@SpringBootApplication
@EnableTransactionManagement
public class SpringbootdemoApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootdemoApplication.class, args);
	}
	@Bean
	public PlatformTransactionManager txManager(@Qualifier("dataSource") DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SpringbootdemoApplication.class);
	}
}
