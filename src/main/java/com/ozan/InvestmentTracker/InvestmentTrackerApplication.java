package com.ozan.InvestmentTracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.ozan.InvestmentTracker.model")
public class InvestmentTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(InvestmentTrackerApplication.class, args);
	}
}
