package edu.ifma.lpweb.rest.imobiliaria.service.impl;

import edu.ifma.lpweb.rest.imobiliaria.controller.request.LocacaoRequest;
import edu.ifma.lpweb.rest.imobiliaria.controller.response.LocacaoResponse;
import edu.ifma.lpweb.rest.imobiliaria.exception.LocacaoNotFoundException;
import edu.ifma.lpweb.rest.imobiliaria.model.Locacao;
import edu.ifma.lpweb.rest.imobiliaria.repository.LocacaoRepository;
import edu.ifma.lpweb.rest.imobiliaria.service.LocacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocacaoServiceImpl implements LocacaoService {
    @Autowired
    private LocacaoRepository locacaoRepository;

    @Override
    public List<LocacaoResponse> findAll() {
        return this.locacaoRepository.findAll().stream().map(LocacaoResponse::toResponse).collect(Collectors.toList());
    }

    @Override
    public LocacaoResponse findById(Long id) {
        return LocacaoResponse.toResponse(this.getLocacao(id));
    }

    @Override
    public LocacaoResponse save(LocacaoRequest locacaoRequest) {
        return LocacaoResponse.toResponse(this.locacaoRepository.save(locacaoRequest.toModel()));
    }

    @Override
    public LocacaoResponse update(LocacaoRequest locacaoRequest, Long id) {
        Locacao locacao = this.getLocacao(id);
        return LocacaoResponse.toResponse(this.locacaoRepository.save(locacaoRequest.toModel(id)));
    }

    @Override
    public void remove(Long id) {
        Locacao locacao = this.getLocacao(id);
        locacao.setAtivo(false);
        this.locacaoRepository.save(locacao);
    }

    private Locacao getLocacao(Long id) {
        return this.locacaoRepository.getOne(id)
                .orElseThrow(() -> new LocacaoNotFoundException("Locação não encontrada para id informado"));
    }
}
