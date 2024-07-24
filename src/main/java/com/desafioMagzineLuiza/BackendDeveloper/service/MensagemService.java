package com.desafioMagzineLuiza.BackendDeveloper.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafioMagzineLuiza.BackendDeveloper.entity.Mensagem;
import com.desafioMagzineLuiza.BackendDeveloper.entity.StatusMensagem;
import com.desafioMagzineLuiza.BackendDeveloper.repository.MensagemRepository;

@Service
public class MensagemService {
    
    @Autowired
    MensagemRepository mensagemRepository;

    @Autowired
    EmailService emailService;


    public void registrarMensagem(Mensagem mensagem){
        mensagemRepository.save(mensagem);
    }

    public void enviarMensagem(Mensagem mensagem){
        emailService.emailMensagem(mensagem);
    }

    public void cancelamentoMensagem(Mensagem mensagem){
        mensagem.setStatus(StatusMensagem.Cancelado);
        this.mensagemRepository.save(mensagem);
    }
    

}
