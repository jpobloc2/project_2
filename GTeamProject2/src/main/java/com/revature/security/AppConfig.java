package com.revature.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.access.SecurityConfig;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
@Import({SecurityConfig.class})
public class AppConfig {
	@Bean(name = "dataSource")
	public DriverManagerDataSource dataSource() {
	    DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
	    driverManagerDataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
	    driverManagerDataSource.setUrl("jdbc:oracle:thin:@goldteam.ctnhn6jczsfw.us-east-2.rds.amazonaws.com:1521:ORCL");
	    driverManagerDataSource.setUsername("gold");
	    driverManagerDataSource.setPassword("goldteamrules");
	    return driverManagerDataSource;
	}

}
