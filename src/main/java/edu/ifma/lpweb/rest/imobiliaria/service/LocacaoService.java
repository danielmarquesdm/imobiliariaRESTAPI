package edu.ifma.lpweb.rest.imobiliaria.service;

import edu.ifma.lpweb.rest.imobiliaria.controller.request.LocacaoRequest;
import edu.ifma.lpweb.rest.imobiliaria.controller.response.LocacaoResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LocacaoService {

    List<LocacaoResponse> findAll();

    LocacaoResponse findById(Long id);

    LocacaoResponse save(LocacaoRequest locacaoRequest);

    LocacaoResponse update(LocacaoRequest locacaoRequest, Long id);

    void remove(Long id);
}
