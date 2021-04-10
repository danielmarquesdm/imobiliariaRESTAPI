package edu.ifma.lpweb.rest.imobiliaria.controller;

import edu.ifma.lpweb.rest.imobiliaria.controller.request.ImovelRequest;
import edu.ifma.lpweb.rest.imobiliaria.controller.response.ImovelResponse;
import edu.ifma.lpweb.rest.imobiliaria.service.ImovelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.net.URI;
import java.util.List;

import static org.springframework.http.ResponseEntity.created;
import static org.springframework.http.ResponseEntity.ok;

@Api(value = "Imovel Endpoint", tags = {"ImovelEndpoint"})
@RestController
@RequestMapping(value = "/imoveis")
public class ImovelController {
    @Autowired
    private ImovelService imovelService;

    @ApiOperation(value = "Busca todos os imóveis registrados com valor default de paginação igual a zero " +
            "e 10 elementos por página")
    @GetMapping
    @Cacheable(value = "listaPaginadaDeImoveis")
    public ResponseEntity<List<ImovelResponse>> findAll(@RequestParam(value = "page", defaultValue = "0") int page,
                                                        @RequestParam(value = "limit", defaultValue = "10") int limit) {
        Pageable pageable = PageRequest.of(page, limit);
        return ok(this.imovelService.findAll(pageable));
    }

    @ApiOperation(value = "Busca imóvel por id")
    @GetMapping(value = "/{id}")
    public ResponseEntity<ImovelResponse> findById(@PathVariable("id") Long id) {
        return ok(this.imovelService.findById(id));
    }

    @ApiOperation(value = "Busca imóveis permitindo filtrar por bairro e/ou valor de aluguel sugerido (menor e maior valor")
    @GetMapping(value = "/search")
    public ResponseEntity<List<ImovelResponse>> searchBy(
            @RequestParam(value = "bairro", required = false) @NotEmpty String bairro,
            @RequestParam(value = "min", required = false) @NotNull BigDecimal minValor,
            @RequestParam(value = "max", required = false) @NotNull BigDecimal maxValor
    ) {
        return ok(this.imovelService.searchBy(bairro, minValor, maxValor));
    }

    @ApiOperation(value = "Cadastra um novo imóvel")
    @PostMapping
    @CacheEvict(value = "listaPaginadaDeImoveis", allEntries = true)
    public ResponseEntity<ImovelResponse> save(@RequestBody @Valid ImovelRequest imovelRequest,
                                               UriComponentsBuilder uriBuilder) {
        var response = this.imovelService.save(imovelRequest);
        URI uri = uriBuilder.path("/imoveis/").buildAndExpand(response.getId()).toUri();
        return created(uri).body(response);
    }

    @ApiOperation(value = "Atualiza um imóvel já cadastrado por id")
    @PutMapping(value = "/{id}")
    public ResponseEntity<ImovelResponse> update(@RequestBody @Valid ImovelRequest imovelRequest, @PathVariable("id") Long id) {
        return ok(this.imovelService.update(imovelRequest, id));
    }

    @ApiOperation(value = "Remove um imóvel já cadastrado usando exclusão lógica")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> remove(@PathVariable("id") Long id) {
        this.imovelService.remove(id);
        return ok().build();
    }
}
