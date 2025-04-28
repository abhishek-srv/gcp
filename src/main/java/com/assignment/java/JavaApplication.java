package com.assignment.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.google.cloud.spring.autoconfigure.pubsub.GcpPubSubAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class,
GcpPubSubAutoConfiguration.class},
scanBasePackages = {"com.assignment.java"})
public class JavaApplication extends SpringBootServletInitializer
{

	public static void main(String[] args) 
	{
		SpringApplication.run(JavaApplication.class, args);
	}

}
