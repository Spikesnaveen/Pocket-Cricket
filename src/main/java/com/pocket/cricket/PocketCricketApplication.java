package com.pocket.cricket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class PocketCricketApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocketCricketApplication.class, args);
	}

}
