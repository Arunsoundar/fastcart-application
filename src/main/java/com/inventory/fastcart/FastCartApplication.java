package com.inventory.fastcart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class FastCartApplication {

	public static void main(String[] args) {
		SpringApplication.run(FastCartApplication.class, args);
		System.out.println(new BCryptPasswordEncoder().encode("admin"));


	}

}
