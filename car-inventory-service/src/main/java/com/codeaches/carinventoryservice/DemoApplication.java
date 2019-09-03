package com.codeaches.carinventoryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

//@SpringBootApplication
//@EnableResourceServer
@SpringBootApplication/*(exclude = {SecurityAutoConfiguration.class,
		UserDetailsServiceAutoConfiguration.class})*/
@ComponentScan(basePackages = {"com.codeaches.carinventoryservice"})
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}

