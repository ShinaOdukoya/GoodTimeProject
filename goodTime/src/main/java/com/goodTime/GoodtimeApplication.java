package com.goodTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.goodTime.config.AppProperties;


@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class GoodtimeApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoodtimeApplication.class, args);
	}
	

}
