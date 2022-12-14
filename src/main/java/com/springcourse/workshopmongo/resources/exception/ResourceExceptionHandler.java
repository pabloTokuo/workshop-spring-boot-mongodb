package com.springcourse.workshopmongo.resources.exception;

import com.springcourse.workshopmongo.services.exception.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // tratar possiveis erros nas requisicoes
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {

        HttpStatus status = HttpStatus.NOT_FOUND; // requisicao http NOT FOUND
        // CurrentTime, transforma status em inteiro, "not found", error message, requestURI para devolver a requisicao
        StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Not found", e.getMessage(), request.getRequestURI());
        // status da requisicao, e dentro do body o err
        return ResponseEntity.status(status).body(err);
    }

}
