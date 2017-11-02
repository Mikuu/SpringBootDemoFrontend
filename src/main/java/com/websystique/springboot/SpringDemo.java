package com.websystique.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Import;

//import com.websystique.springboot.configuration.JpaConfiguration;


//@Import(JpaConfiguration.class)
@SpringBootApplication()// same as @Configuration @EnableAutoConfiguration @ComponentScan
public class SpringDemo {

	public static void main(String[] args) {
		SpringApplication.run(SpringDemo.class, args);
	}
}
