package edu.ifma.lpweb.rest.imobiliaria.service;

import edu.ifma.lpweb.rest.imobiliaria.controller.response.ClienteResponse;
import edu.ifma.lpweb.rest.imobiliaria.model.Cliente;
import edu.ifma.lpweb.rest.imobiliaria.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


public interface ClienteService {
    List<ClienteResponse> findAll();

    ClienteResponse findById(Integer id);
}
