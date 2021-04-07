package com.mobileservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MobileServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MobileServiceApplication.class, args);
	}

}
