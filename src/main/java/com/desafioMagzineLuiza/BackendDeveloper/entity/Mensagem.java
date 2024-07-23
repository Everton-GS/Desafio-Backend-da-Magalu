package com.desafioMagzineLuiza.BackendDeveloper.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "db_mensagem")
public class Mensagem {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "mensagem")
    private String mensagem;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss", timezone = "UTC")
    @Column(name = "horario_gerada")
    private LocalDateTime mensagemCriada;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss", timezone = "UTC")
    @NotNull(message = "horário de envio em branco")
    @Column(name = "horario_envio")
    private LocalDateTime envio;

    @Email
    @Column(name = "email")
    @NotBlank(message = "escreva o e-mail de envio")
    private String email;
    
    @Column(name = "status")
    private StatusMensagem status;


    
    
}
