package com.pc.gpu.config;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DBConfig {

	static final Logger logger = LogManager.getLogger(DBConfig.class);
	
	@Bean
	public static Properties jdbcProperties() {
		
		logger.info("Initializing properties in DBConfig class");	
		
		Properties prop = new Properties();
		
		prop.setProperty("hibernate.connection.url", "");
		prop.setProperty("dialect", "org.hibernate.dialect.MySQLDialect");
        prop.setProperty("hibernate.connection.username", "");
        prop.setProperty("hibernate.connection.password", "");
        prop.setProperty("hibernate.connection.driver_class","com.mysql.jdbc.Driver");
        prop.setProperty("show_sql", "true");
        prop.setProperty("hibernate.current_session_context_class", "thread");

        return prop;
	}
}
