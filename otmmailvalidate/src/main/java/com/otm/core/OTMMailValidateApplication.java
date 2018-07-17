package com.otm.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class OTMMailValidateApplication extends SpringBootServletInitializer {
	 @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(OTMMailValidateApplication.class);
	    }

	public static void main(String[] args) {
		SpringApplication.run(OTMMailValidateApplication.class, args);
	}
}
