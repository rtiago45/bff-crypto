package com.example.bff_crypto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class BffCryptoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BffCryptoApplication.class, args);
	}

}
