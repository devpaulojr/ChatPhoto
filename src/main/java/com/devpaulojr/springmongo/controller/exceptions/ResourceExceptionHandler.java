package com.devpaulojr.springmongo.controller.exceptions;

import com.devpaulojr.springmongo.model.User;
import com.devpaulojr.springmongo.services.exceptions.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException exception,
                                                 HttpServletRequest servletRequest){

        HttpStatus status = HttpStatus.NOT_FOUND;
        String error = "Objeto não encontrado!!";

        StandardError standardError = new StandardError(Instant.now(),
                status.value(),
                error,
                exception.getMessage(),
                servletRequest.getRequestURI());
        return ResponseEntity.status(status).body(standardError);
    }
}
