package edu.ifma.lpweb.rest.imobiliaria.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AluguelNotFoundException extends RuntimeException {
    public AluguelNotFoundException(String message) {
        super(message);
    }
}
