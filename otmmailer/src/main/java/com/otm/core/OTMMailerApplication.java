package com.otm.core;

import java.time.LocalDateTime;
import java.util.Calendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class OTMMailerApplication {

	public static void main(String[] args) {
		SpringApplication.run(OTMMailerApplication.class, args);
	}
	

}
