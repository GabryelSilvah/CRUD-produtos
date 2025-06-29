package com.projeto.produtos.exceptions;

public class RegistroExistsException extends RuntimeException {

    public RegistroExistsException() {
        super("Registo já existe na base de dados");
    }

    public RegistroExistsException(String message) {
        super(message);
    }

}

