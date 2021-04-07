package edu.ifma.lpweb.rest.imobiliaria.service.impl;

import edu.ifma.lpweb.rest.imobiliaria.controller.request.ClienteRequest;
import edu.ifma.lpweb.rest.imobiliaria.controller.response.ClienteResponse;
import edu.ifma.lpweb.rest.imobiliaria.model.Cliente;
import edu.ifma.lpweb.rest.imobiliaria.repository.ClienteRepository;
import edu.ifma.lpweb.rest.imobiliaria.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl implements ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<ClienteResponse> findAll() {
        return this.clienteRepository.findAll().stream().map(ClienteResponse::toResponse).collect(Collectors.toList());
    }

    @Override
    public ClienteResponse findById(Integer id) {
        return ClienteResponse.toResponse(this.getCliente(id));
    }

    @Override
    public ClienteResponse save(ClienteRequest clienteRequest) {
        return ClienteResponse.toResponse(this.clienteRepository.save(clienteRequest.toModel()));
    }

    private Cliente getCliente(Integer id) {
        return this.clienteRepository.getOne(id);
    }
}
