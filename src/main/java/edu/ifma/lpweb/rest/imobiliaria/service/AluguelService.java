package edu.ifma.lpweb.rest.imobiliaria.service;

import edu.ifma.lpweb.rest.imobiliaria.controller.response.AluguelResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AluguelService {
    List<AluguelResponse> findAll();

    AluguelResponse findById(Long id);
}
