package com.desafioMagzineLuiza.BackendDeveloper.exception;

import java.sql.SQLException;
import java.util.concurrent.TimeoutException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Configuracao {
    

    @ExceptionHandler(SQLException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleSQLExceptions(SQLException ex) {
        return ResponseEntity.badRequest().body("Erro no sql: " + ex.getMessage());
    }

    @ExceptionHandler(TimeoutException.class)
    @ResponseStatus(HttpStatus.REQUEST_TIMEOUT)
    public ResponseEntity<String> handleTimeException(TimeoutException time){
        return ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT).body("Tempo de processamento de solicitação excedido"+ time.getMessage());    
    }
    
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<String> handlerInternoServidor(Exception ex){
        return ResponseEntity.internalServerError().body("Erro interno servidor");
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<String> handleNullPointerException(NullPointerException ex) {
        return ResponseEntity.internalServerError().body("Erro interno do servidor: NullPointerException");
    }


    
}