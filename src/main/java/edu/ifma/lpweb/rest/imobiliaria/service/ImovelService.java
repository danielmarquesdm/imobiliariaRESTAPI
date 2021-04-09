package edu.ifma.lpweb.rest.imobiliaria.service;

import edu.ifma.lpweb.rest.imobiliaria.controller.request.ImovelRequest;
import edu.ifma.lpweb.rest.imobiliaria.controller.response.ImovelResponse;
import edu.ifma.lpweb.rest.imobiliaria.model.Imovel;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public interface ImovelService {
    List<Imovel> findAll();

    ImovelResponse findById(Long id);

    ImovelResponse save(ImovelRequest imovelRequest);

    ImovelResponse update(ImovelRequest imovelRequest, Long id);

    void remove(Long id);

    List<ImovelResponse> searchBy(String bairro, BigDecimal minValor, BigDecimal maxValor);
}
