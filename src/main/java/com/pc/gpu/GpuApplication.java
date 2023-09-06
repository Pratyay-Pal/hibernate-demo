package com.pc.gpu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class GpuApplication {

	public static void main(String[] args) {
		SpringApplication.run(GpuApplication.class, args);
	}

}
