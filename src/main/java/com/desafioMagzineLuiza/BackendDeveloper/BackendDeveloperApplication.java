package com.desafioMagzineLuiza.BackendDeveloper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import com.desafioMagzineLuiza.BackendDeveloper.controller.MensagemController;

@EnableScheduling
@SpringBootApplication
public class BackendDeveloperApplication {

	@Autowired
	MensagemController mensagemController;

	public static void main(String[] args) {
		SpringApplication.run(BackendDeveloperApplication.class, args);
	}

	

}
