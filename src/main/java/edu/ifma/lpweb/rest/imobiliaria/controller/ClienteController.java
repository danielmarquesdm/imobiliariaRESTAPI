package edu.ifma.lpweb.rest.imobiliaria.controller;

import edu.ifma.lpweb.rest.imobiliaria.controller.request.ClienteRequest;
import edu.ifma.lpweb.rest.imobiliaria.controller.response.ClienteResponse;
import edu.ifma.lpweb.rest.imobiliaria.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.net.URI;
import java.util.List;

import static org.springframework.http.ResponseEntity.created;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<ClienteResponse>> findAll() {
        return ok(this.clienteService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClienteResponse> findById(@PathVariable("id") @NotEmpty Long id) {
        return ok(this.clienteService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ClienteResponse> save(@RequestBody @Valid ClienteRequest clienteRequest,
                                                UriComponentsBuilder uriBuilder) {
        var response = this.clienteService.save(clienteRequest);
        URI uri = uriBuilder.path("/clientes").buildAndExpand(response.getId()).toUri();
        return created(uri).body(response);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ClienteResponse> update(@RequestBody @Valid ClienteRequest clienteRequest,
                                                  @PathVariable("id") Long id) {
        return ok(this.clienteService.update(clienteRequest, id));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> remove(@PathVariable("id") Long id) {
        this.clienteService.remove(id);
        return ok().build();
    }
}
