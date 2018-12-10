package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
import org.springframework.context.annotation.Import;
import com.example.demo.security.WebSecurityConfig;

@Import(WebSecurityConfig.class)
//*/
@SpringBootApplication
public class TpEtudiantApplication {

	public static void main(String[] args) {
		SpringApplication.run(TpEtudiantApplication.class, args);
	}
}
