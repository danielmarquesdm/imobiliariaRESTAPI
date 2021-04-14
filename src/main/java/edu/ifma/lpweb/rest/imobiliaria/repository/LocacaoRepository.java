package edu.ifma.lpweb.rest.imobiliaria.repository;

import edu.ifma.lpweb.rest.imobiliaria.model.Locacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocacaoRepository extends JpaRepository<Locacao, String> {
    @Query("FROM Locacao l " +
            "WHERE l.id = :id " +
            "AND l.ativo = true")
    Optional<Locacao> getOne(Long id);
}
