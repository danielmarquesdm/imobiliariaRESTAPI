package edu.ifma.lpweb.rest.imobiliaria.repository.impl;

import edu.ifma.lpweb.rest.imobiliaria.model.Imovel;
import edu.ifma.lpweb.rest.imobiliaria.repository.ImovelDynamicQueriesRepository;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class ImovelRepositoryImpl implements ImovelDynamicQueriesRepository {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Imovel> searchBy(String bairro, BigDecimal minValor, BigDecimal maxValor) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Imovel> criteriaQuery = builder.createQuery(Imovel.class);

        Root<Imovel> root = criteriaQuery.from(Imovel.class);

        var predicates = new ArrayList<Predicate>();

        if (StringUtils.hasText(bairro)) {
            Predicate bairroPredicate = builder.like(root.get("endereco"), "%" + bairro + "%");
            predicates.add(bairroPredicate);
        }

        if (minValor != null) {
            Predicate minPredicate = builder.greaterThanOrEqualTo(root.get("valorDeAluguelSugerido"), minValor);
            predicates.add(minPredicate);
        }

        if (maxValor != null) {
            Predicate maxPredicate = builder.lessThanOrEqualTo(root.get("valorDeAluguelSugerido"), maxValor);
            predicates.add(maxPredicate);
        }

        if (predicates.isEmpty()) {
            return Collections.emptyList();
        }

        criteriaQuery.where(predicates.toArray(new Predicate[0]));

        TypedQuery<Imovel> query = manager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
