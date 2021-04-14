package edu.ifma.lpweb.rest.imobiliaria.service;

import edu.ifma.lpweb.rest.imobiliaria.controller.request.AluguelRequest;
import edu.ifma.lpweb.rest.imobiliaria.controller.response.AluguelResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AluguelService {
    List<AluguelResponse> findAll();

    AluguelResponse findById(Long id);

    AluguelResponse save(AluguelRequest aluguelRequest);

    AluguelResponse update(AluguelRequest aluguelRequest, Long id);

    void remove(Long id);
}
