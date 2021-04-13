package edu.ifma.lpweb.rest.imobiliaria.controller;

import edu.ifma.lpweb.rest.imobiliaria.controller.response.AluguelResponse;
import edu.ifma.lpweb.rest.imobiliaria.service.AluguelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.ResponseEntity.*;

@Api(value = "Aluguel Endpoint", tags = {"AluguelEndpoint"})
@RequestMapping(value = "/alugueis")
@RestController
public class AluguelController {
    @Autowired
    private AluguelService aluguelService;

    @ApiOperation(value = "Busca todos os alugueis registrados")
    @GetMapping
    public ResponseEntity<List<AluguelResponse>> findAll() {
        return ok(this.aluguelService.findAll());
    }

    @ApiOperation(value = "Busca pelo id um aluguel já cadastrado")
    @GetMapping(value = "/{id}")
    public ResponseEntity<AluguelResponse> findById(@PathVariable("id") Long id) {
        return ok(this.aluguelService.findById(id));
    }
}
