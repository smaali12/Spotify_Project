package com.example.UserAuth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class UserAuthClass {

	public static void main(String[] args)
	{
		SpringApplication.run(UserAuthClass.class, args);
	}

}
