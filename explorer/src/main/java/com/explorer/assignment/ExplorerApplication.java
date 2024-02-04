package com.explorer.assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.")
public class ExplorerApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(ExplorerApplication.class, args);

	}

}
