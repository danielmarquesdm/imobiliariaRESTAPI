package edu.ifma.lpweb.rest.imobiliaria.service.impl;

import edu.ifma.lpweb.rest.imobiliaria.controller.request.ImovelRequest;
import edu.ifma.lpweb.rest.imobiliaria.controller.response.ImovelResponse;
import edu.ifma.lpweb.rest.imobiliaria.exception.ImovelNotFoundException;
import edu.ifma.lpweb.rest.imobiliaria.model.Imovel;
import edu.ifma.lpweb.rest.imobiliaria.repository.ImovelRepository;
import edu.ifma.lpweb.rest.imobiliaria.service.ImovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    private Imovel getImovel(Long id) {
        return this.imovelRepository.getOne(id)
                .orElseThrow(() -> new ImovelNotFoundException("Imovel não encontrado para id informado"));
    }
}
