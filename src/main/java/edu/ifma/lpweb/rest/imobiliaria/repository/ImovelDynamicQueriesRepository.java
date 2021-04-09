package edu.ifma.lpweb.rest.imobiliaria.repository;

import edu.ifma.lpweb.rest.imobiliaria.model.Imovel;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ImovelDynamicQueriesRepository {
    List<Imovel> searchBy(@Param("bairro") String bairro, @Param("min") BigDecimal minValor, @Param("max") BigDecimal maxValor);
}
