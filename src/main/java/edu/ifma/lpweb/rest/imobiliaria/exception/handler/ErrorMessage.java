package edu.ifma.lpweb.rest.imobiliaria.exception.handler;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ErrorMessage {
    private Integer statusCode;
    private String message;
}
