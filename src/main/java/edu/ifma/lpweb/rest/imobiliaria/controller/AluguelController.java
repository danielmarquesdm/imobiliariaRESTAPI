package edu.ifma.lpweb.rest.imobiliaria.controller;

import edu.ifma.lpweb.rest.imobiliaria.controller.request.AluguelRequest;
import edu.ifma.lpweb.rest.imobiliaria.controller.response.AluguelResponse;
import edu.ifma.lpweb.rest.imobiliaria.service.AluguelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
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

    @ApiOperation(value = "")
    @PostMapping
    public ResponseEntity<AluguelResponse> save(@RequestBody @Valid AluguelRequest aluguelRequest,
                                                UriComponentsBuilder uriBuilder) {
        AluguelResponse response = this.aluguelService.save(aluguelRequest);
        URI uri = uriBuilder.path("/alugueis").buildAndExpand(response.getId()).toUri();
        return created(uri).body(response);
    }

    @ApiOperation(value = "Atualiza um aluguel já registrado pelo id")
    @PutMapping(value = "/{id}")
    public ResponseEntity<AluguelResponse> update(@RequestBody @Valid AluguelRequest aluguelRequest,
                                                  @PathVariable("id") Long id) {
        return ok(this.aluguelService.update(aluguelRequest, id));
    }

    @ApiOperation(value = "Remove um aluguel já registrado pelo id")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> remove(@PathVariable("id") Long id) {
        this.aluguelService.remove(id);
        return ok().build();
    }
}
