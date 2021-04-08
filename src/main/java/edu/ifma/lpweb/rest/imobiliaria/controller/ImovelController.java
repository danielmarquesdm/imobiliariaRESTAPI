package edu.ifma.lpweb.rest.imobiliaria.controller;

import edu.ifma.lpweb.rest.imobiliaria.controller.request.ImovelRequest;
import edu.ifma.lpweb.rest.imobiliaria.controller.response.ImovelResponse;
import edu.ifma.lpweb.rest.imobiliaria.model.Imovel;
import edu.ifma.lpweb.rest.imobiliaria.service.ImovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static org.springframework.http.ResponseEntity.created;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping(value = "/imoveis/")
public class ImovelController {
    @Autowired
    private ImovelService imovelService;

    @GetMapping
    public ResponseEntity<List<Imovel>> findAll() {
        return ok(this.imovelService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ImovelResponse> findById(@PathVariable("id") Long id) {
        return ok(this.imovelService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ImovelResponse> save(@RequestBody @Valid ImovelRequest imovelRequest,
                                               UriComponentsBuilder uriBuilder) {
        var response = this.imovelService.save(imovelRequest);
        URI uri = uriBuilder.path("/imoveis/").buildAndExpand(response.getId()).toUri();
        return created(uri).body(response);
    }
}
