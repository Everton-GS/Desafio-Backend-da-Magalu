package com.desafioMagzineLuiza.BackendDeveloper.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;


import com.desafioMagzineLuiza.BackendDeveloper.controller.MensagemController;


@Configuration
@EnableScheduling
public class SheduledJob {
    
    @Autowired
	MensagemController mensagemController;

    @Scheduled(fixedRate = 60000)
	public void job(){
		mensagemController.enviarEmail();
	}
}
