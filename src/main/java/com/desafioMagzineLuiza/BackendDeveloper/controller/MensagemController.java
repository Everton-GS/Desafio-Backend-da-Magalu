package com.desafioMagzineLuiza.BackendDeveloper.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.desafioMagzineLuiza.BackendDeveloper.dto.MensagemSalvar;
import com.desafioMagzineLuiza.BackendDeveloper.entity.Mensagem;
import com.desafioMagzineLuiza.BackendDeveloper.entity.StatusMensagem;
import com.desafioMagzineLuiza.BackendDeveloper.repository.MensagemRepository;
import com.desafioMagzineLuiza.BackendDeveloper.service.MensagemService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/mensagem")
public class MensagemController {
    
    @Autowired
    MensagemService mensagemService;

    @Autowired 
    MensagemRepository mensagemRepository;

    @PostMapping("/registrar")
    public ResponseEntity<?> enviarMensagem(@RequestBody MensagemSalvar mensagemSalvar){
        Mensagem mensagem = new Mensagem(null, mensagemSalvar.mensagem(), LocalDateTime.now(), mensagemSalvar.envio(), mensagemSalvar.email(),StatusMensagem.Espera);
        mensagemService.registrarMensagem(mensagem);
        return ResponseEntity.ok().build();
    }

    @Transactional
    @PutMapping("/enviar")
    public ResponseEntity<?> enviarEmail(){
        List<Mensagem> lista= mensagemRepository.findByMensagemEspera();
        for(Mensagem mensagem:lista){
            if(LocalDateTime.now().isAfter(mensagem.getEnvio())){
                mensagemService.enviarMensagem(mensagem);
            }
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Mensagem>>listarAll(){
        List<Mensagem> lista= mensagemRepository.findAll();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/listar/espera")
    public ResponseEntity<List<Mensagem>>listarEspera(){
        List<Mensagem> lista= mensagemRepository.findByMensagemEspera();
        return ResponseEntity.ok(lista);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<?>cancelamentoMensagem(@PathVariable Long id) {
        Optional<Mensagem> mensagem = mensagemRepository.findById(id);
        mensagemService.cancelamentoMensagem(mensagem.get());
        return ResponseEntity.ok().build();
    }




}
