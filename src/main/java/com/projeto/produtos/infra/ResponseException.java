package com.projeto.produtos.infra;

import com.projeto.produtos.exceptions.RegistroExistsException;
import com.projeto.produtos.exceptions.RegistroNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ResponseException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RegistroNotFoundException.class)
    public ResponseEntity<?> userNotFound(RegistroNotFoundException excetion) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(excetion.getMessage());
    }

    @ExceptionHandler(RegistroExistsException.class)
    public ResponseEntity<?> userNotFound(RegistroExistsException excetion) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(excetion.getMessage());
    }

}
