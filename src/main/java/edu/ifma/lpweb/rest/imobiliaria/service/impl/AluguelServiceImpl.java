package edu.ifma.lpweb.rest.imobiliaria.service.impl;

import edu.ifma.lpweb.rest.imobiliaria.controller.request.AluguelRequest;
import edu.ifma.lpweb.rest.imobiliaria.controller.response.AluguelResponse;
import edu.ifma.lpweb.rest.imobiliaria.exception.AluguelNotFoundException;
import edu.ifma.lpweb.rest.imobiliaria.model.Aluguel;
import edu.ifma.lpweb.rest.imobiliaria.repository.AluguelRepository;
import edu.ifma.lpweb.rest.imobiliaria.service.AluguelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    @Override
    public AluguelResponse save(AluguelRequest aluguelRequest) {
        return AluguelResponse.toResponse(this.aluguelRepository.save(aluguelRequest.toModel()));
    }

    @Override
    public AluguelResponse update(AluguelRequest aluguelRequest, Long id) {
        final Aluguel response = this.getAluguel(id);
        return AluguelResponse.toResponse(this.aluguelRepository.save(aluguelRequest.toModel(response.getId())));
    }

    @Override
    public void remove(Long id) {
        final var aluguel = this.getAluguel(id);
        aluguel.setDeletedAt(LocalDateTime.now());
        this.aluguelRepository.save(aluguel);
    }

    private Aluguel getAluguel(Long id) {
        return this.aluguelRepository.getOne(id)
                .orElseThrow(() -> new AluguelNotFoundException("Não existe aluguel para o id informado"));
    }
}
