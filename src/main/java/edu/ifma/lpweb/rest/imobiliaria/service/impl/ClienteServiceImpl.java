package edu.ifma.lpweb.rest.imobiliaria.service.impl;

import edu.ifma.lpweb.rest.imobiliaria.controller.request.ClienteRequest;
import edu.ifma.lpweb.rest.imobiliaria.controller.response.ClienteResponse;
import edu.ifma.lpweb.rest.imobiliaria.exception.ClienteNotFoundException;
import edu.ifma.lpweb.rest.imobiliaria.model.Cliente;
import edu.ifma.lpweb.rest.imobiliaria.repository.ClienteRepository;
import edu.ifma.lpweb.rest.imobiliaria.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
    public ClienteResponse findById(Long id) {
        return ClienteResponse.toResponse(this.getCliente(id));
    }

    @Override
    public ClienteResponse save(ClienteRequest clienteRequest) {
        return ClienteResponse.toResponse(this.clienteRepository.save(clienteRequest.toModel()));
    }

    @Override
    public ClienteResponse update(ClienteRequest clienteRequest, Long id) {
        final Cliente response = this.getCliente(id);
        return ClienteResponse.toResponse(this.clienteRepository.save(clienteRequest.toModel(response.getId())));
    }

    @Override
    public void remove(Long id) {
        Cliente cliente = this.getCliente(id);
        cliente.setDeletedAt(LocalDateTime.now());
        this.clienteRepository.save(cliente);
    }

    private Cliente getCliente(Long id) {
        return this.clienteRepository.getOne(id)
                .orElseThrow(() -> new ClienteNotFoundException("Não existe cliente para o id informado"));
    }
}
