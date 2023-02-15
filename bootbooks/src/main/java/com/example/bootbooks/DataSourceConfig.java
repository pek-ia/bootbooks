package com.example.bootbooks;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {
	
	@Bean
	DataSource getDataSource() {
        DataSourceBuilder<?> dsb = DataSourceBuilder.create();
        dsb.driverClassName("org.h2.Driver");
        dsb.url("jdbc:h2:D:/MYWORK/bookdb");
        dsb.username("SA");
        dsb.password("");
        return dsb.build();
	}

}
