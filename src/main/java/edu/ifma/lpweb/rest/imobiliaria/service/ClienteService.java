package edu.ifma.lpweb.rest.imobiliaria.service;

import edu.ifma.lpweb.rest.imobiliaria.controller.request.ClienteRequest;
import edu.ifma.lpweb.rest.imobiliaria.controller.response.ClienteResponse;

import java.util.List;


public interface ClienteService {
    List<ClienteResponse> findAll();

    ClienteResponse findById(Long id);

    ClienteResponse save(ClienteRequest clienteRequest);

    ClienteResponse update(ClienteRequest clienteRequest, Long id);

    void remove(Long id);
}
