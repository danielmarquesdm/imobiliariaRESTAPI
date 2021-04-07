package edu.ifma.lpweb.rest.imobiliaria.controller;

import edu.ifma.lpweb.rest.imobiliaria.controller.request.ClienteRequest;
import edu.ifma.lpweb.rest.imobiliaria.controller.response.ClienteResponse;
import edu.ifma.lpweb.rest.imobiliaria.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<ClienteResponse> save(@RequestBody ClienteRequest clienteRequest) {
        return ok(this.clienteService.save(clienteRequest));
    }
}
