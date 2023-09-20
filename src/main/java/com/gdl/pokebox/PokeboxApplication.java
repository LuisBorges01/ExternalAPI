package com.gdl.pokebox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class PokeboxApplication {

	public static void main(String[] args) {
		SpringApplication.run(PokeboxApplication.class, args);
	}

}
