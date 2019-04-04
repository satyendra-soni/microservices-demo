package com.sarathisoftech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

//@EnableWebSecurity
@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
public class ZullApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZullApiGatewayApplication.class, args);
	}
	/*@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(); // For encrypting user password
	}*/
}
