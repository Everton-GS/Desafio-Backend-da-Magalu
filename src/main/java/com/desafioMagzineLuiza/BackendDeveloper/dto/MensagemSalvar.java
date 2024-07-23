package com.desafioMagzineLuiza.BackendDeveloper.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MensagemSalvar(@NotBlank String mensagem,@NotBlank String email,@JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss", timezone = "UTC") @NotNull LocalDateTime envio) {
    
}
