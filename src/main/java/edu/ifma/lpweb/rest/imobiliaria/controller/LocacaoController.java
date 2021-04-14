package edu.ifma.lpweb.rest.imobiliaria.controller;

import edu.ifma.lpweb.rest.imobiliaria.controller.request.LocacaoRequest;
import edu.ifma.lpweb.rest.imobiliaria.controller.response.LocacaoResponse;
import edu.ifma.lpweb.rest.imobiliaria.service.LocacaoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static org.springframework.http.ResponseEntity.created;
import static org.springframework.http.ResponseEntity.ok;

@ApiOperation(value = "Locacao Endpoint", tags = {"LocacaoEndpoint"})
@RequestMapping(value = "/locacoes")
@RestController
public class LocacaoController {
    @Autowired
    private LocacaoService locacaoService;

    @ApiOperation(value = "Busca todos as locacoes registradas")
    @GetMapping
    public ResponseEntity<List<LocacaoResponse>> findAll() {
        return ok(this.locacaoService.findAll());
    }

    @ApiOperation(value = "Busca pelo id uma locação já cadastrado")
    @GetMapping(value = "/{id}")
    public ResponseEntity<LocacaoResponse> findById(@PathVariable("id") Long id) {
        return ok(this.locacaoService.findById(id));
    }

    @ApiOperation(value = "Cadastra uma nova locação")
    @PostMapping
    public ResponseEntity<LocacaoResponse> save(@RequestBody @Valid LocacaoRequest locacaoRequest,
                                                UriComponentsBuilder uriBuilder) {
        LocacaoResponse response = this.locacaoService.save(locacaoRequest);
        URI uri = uriBuilder.path("/alugueis").buildAndExpand(response.getId()).toUri();
        return created(uri).body(response);
    }

    @ApiOperation(value = "Atualiza uma locação já registrada pelo id")
    @PutMapping(value = "/{id}")
    public ResponseEntity<LocacaoResponse> update(@RequestBody @Valid LocacaoRequest locacaoRequest,
                                                  @PathVariable("id") Long id) {
        return ok(this.locacaoService.update(locacaoRequest, id));
    }

    @ApiOperation(value = "Remove uma locação já registrada pelo id")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> remove(@PathVariable("id") Long id) {
        this.locacaoService.remove(id);
        return ok().build();
    }
}
