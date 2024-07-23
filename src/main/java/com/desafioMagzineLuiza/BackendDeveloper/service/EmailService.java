package com.desafioMagzineLuiza.BackendDeveloper.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.desafioMagzineLuiza.BackendDeveloper.entity.Mensagem;
import com.desafioMagzineLuiza.BackendDeveloper.entity.StatusMensagem;
import com.desafioMagzineLuiza.BackendDeveloper.repository.MensagemRepository;

@Service
public class EmailService {
    
    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    MensagemRepository mensagemRepository;

    @Value("${spring.mail.username}")
    private String email;

    public void emailMensagem(Mensagem mensagem){
        String assunto="Magazine Luiza";

        SimpleMailMessage simpleMailMessage= new SimpleMailMessage();
        simpleMailMessage.setFrom(email);
        simpleMailMessage.setTo(mensagem.getEmail());
        simpleMailMessage.setSubject(assunto);
        simpleMailMessage.setText(mensagem.getMensagem());
        javaMailSender.send(simpleMailMessage);

        mensagem.setStatus(StatusMensagem.Enviado);
        mensagemRepository.save(mensagem);
    }
}
