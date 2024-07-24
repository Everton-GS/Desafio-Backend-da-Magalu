package com.desafioMagzineLuiza.BackendDeveloper.entity;

public enum StatusMensagem {

    Enviado("enviado"),
    Espera("espera"),
    Cancelado("cancelado");
    
    private String status;

    private StatusMensagem(String status){
        this.status=status;
    }

    public String getStatus() {
        return status;
    }

    
}
