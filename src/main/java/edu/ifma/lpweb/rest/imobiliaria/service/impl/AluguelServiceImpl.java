package edu.ifma.lpweb.rest.imobiliaria.service.impl;

import edu.ifma.lpweb.rest.imobiliaria.controller.response.AluguelResponse;
import edu.ifma.lpweb.rest.imobiliaria.exception.AluguelNotFoundException;
import edu.ifma.lpweb.rest.imobiliaria.model.Aluguel;
import edu.ifma.lpweb.rest.imobiliaria.repository.AluguelRepository;
import edu.ifma.lpweb.rest.imobiliaria.service.AluguelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AluguelServiceImpl implements AluguelService {
    @Autowired
    private AluguelRepository aluguelRepository;

    @Override
    public List<AluguelResponse> findAll() {
        return aluguelRepository.findAll().stream().map(AluguelResponse::toResponse).collect(Collectors.toList());
    }

    @Override
    public AluguelResponse findById(Long id) {
        return AluguelResponse.toResponse(this.getAluguel(id));
    }

    private Aluguel getAluguel(Long id) {
        return this.aluguelRepository.getOne(id)
                .orElseThrow(() -> new AluguelNotFoundException("Não existe aluguel para o id informado"));
    }
}
