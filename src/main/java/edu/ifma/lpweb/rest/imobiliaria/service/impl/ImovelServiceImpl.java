package edu.ifma.lpweb.rest.imobiliaria.service.impl;

import edu.ifma.lpweb.rest.imobiliaria.controller.request.ImovelRequest;
import edu.ifma.lpweb.rest.imobiliaria.controller.response.ImovelResponse;
import edu.ifma.lpweb.rest.imobiliaria.exception.ImovelNotFoundException;
import edu.ifma.lpweb.rest.imobiliaria.model.Imovel;
import edu.ifma.lpweb.rest.imobiliaria.repository.ImovelRepository;
import edu.ifma.lpweb.rest.imobiliaria.service.ImovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImovelServiceImpl implements ImovelService {
    @Autowired
    private ImovelRepository imovelRepository;

    @Override
    public List<Imovel> findAll() {
        return this.imovelRepository.findAll();
    }

    @Override
    public ImovelResponse findById(Long id) {
        return ImovelResponse.toResponse(this.getImovel(id));
    }

    @Override
    public ImovelResponse save(ImovelRequest imovelRequest) {
        return ImovelResponse.toResponse(this.imovelRepository.save(imovelRequest.toModel()));
    }

    @Override
    public ImovelResponse update(ImovelRequest imovelRequest, Long id) {
        final Imovel response = this.getImovel(id);
        return ImovelResponse.toResponse(this.imovelRepository.save(imovelRequest.toModel(response.getId())));
    }

    @Override
    public void remove(Long id) {
        final Imovel imovel = this.getImovel(id);
        imovel.setDeletedAt(LocalDateTime.now());
        this.imovelRepository.save(imovel);
    }

    @Override
    public List<ImovelResponse> searchBy(String bairro, BigDecimal minValor, BigDecimal maxValor) {
        return this.imovelRepository.searchBy(bairro, minValor, maxValor).stream()
                .map(ImovelResponse::toResponse).collect(Collectors.toList());
    }

    private Imovel getImovel(Long id) {
        return this.imovelRepository.getOne(id)
                .orElseThrow(() -> new ImovelNotFoundException("Imovel não encontrado para id informado"));
    }
}
