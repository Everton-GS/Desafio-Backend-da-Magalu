package com.desafioMagzineLuiza.BackendDeveloper.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafioMagzineLuiza.BackendDeveloper.entity.Mensagem;

public interface MensagemRepository extends JpaRepository<Mensagem,Long> {
    
}
