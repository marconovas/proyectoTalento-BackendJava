package com.example.articulos.exception;

public class ArticuloNoEncontradoException extends RuntimeException{
    public ArticuloNoEncontradoException(String mensaje) {
        super(mensaje);
    }

}
