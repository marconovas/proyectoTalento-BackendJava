package com.example.articulos.exception;

public class RecursoNoEncontradoException extends RuntimeException{
    public RecursoNoEncontradoException (String mensaje) {
        super(mensaje);
    }
}
