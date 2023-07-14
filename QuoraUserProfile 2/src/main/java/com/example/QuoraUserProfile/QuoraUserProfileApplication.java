package com.example.QuoraUserProfile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication
@EnableFeignClients
public class QuoraUserProfileApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuoraUserProfileApplication.class, args);
	}

}
