package edu.ifma.lpweb.rest.imobiliaria.exception.handler;

import edu.ifma.lpweb.rest.imobiliaria.exception.AluguelNotFoundException;
import edu.ifma.lpweb.rest.imobiliaria.exception.ClienteNotFoundException;
import edu.ifma.lpweb.rest.imobiliaria.exception.ImovelNotFoundException;
import edu.ifma.lpweb.rest.imobiliaria.exception.LocacaoNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.ResponseEntity.badRequest;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ClienteNotFoundException.class)
    public ResponseEntity<?> handleClienteNotFoundException(ClienteNotFoundException ex) {
        ErrorMessage errorMessage = ErrorMessage.builder()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .message(ex.getMessage()).build();
        return badRequest().body(errorMessage);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request) {
        ErrorMessage errorMessage = ErrorMessage.builder()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .message(ex.getMessage())
                .build();
        return super.handleExceptionInternal(ex, errorMessage, headers, HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(AluguelNotFoundException.class)
    public ResponseEntity<?> handleAluguelNotFoundException(AluguelNotFoundException ex) {
        ErrorMessage errorMessage = ErrorMessage.builder()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .message(ex.getMessage()).build();
        return badRequest().body(errorMessage);
    }

    @ExceptionHandler(ImovelNotFoundException.class)
    public ResponseEntity<?> handleImovelNotFoundException(ImovelNotFoundException ex) {
        ErrorMessage errorMessage = ErrorMessage.builder()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .message(ex.getMessage()).build();
        return badRequest().body(errorMessage);
    }

    @ExceptionHandler(LocacaoNotFoundException.class)
    public ResponseEntity<?> handleLocacaoNotFoundException(LocacaoNotFoundException ex) {
        ErrorMessage errorMessage = ErrorMessage.builder()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .message(ex.getMessage()).build();
        return badRequest().body(errorMessage);
    }
}
