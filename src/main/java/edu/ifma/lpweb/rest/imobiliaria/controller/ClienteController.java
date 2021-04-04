package edu.ifma.lpweb.rest.imobiliaria.controller;

import edu.ifma.lpweb.rest.imobiliaria.controller.response.ClienteResponse;
import edu.ifma.lpweb.rest.imobiliaria.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/clientes/")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<ClienteResponse>> findAll() {
        return ok(this.clienteService.findAll());
    }   

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClienteResponse> findById(@PathVariable("id") Integer id) {
        return ok(this.clienteService.findById(id));
    }
}
