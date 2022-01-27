package com.hyunsdb.hambook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class HambookApplication {

	public static void main(String[] args) {
		SpringApplication.run(HambookApplication.class, args);
	}

}
