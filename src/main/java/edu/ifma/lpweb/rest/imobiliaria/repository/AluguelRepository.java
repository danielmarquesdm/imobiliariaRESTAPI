package edu.ifma.lpweb.rest.imobiliaria.repository;

import edu.ifma.lpweb.rest.imobiliaria.model.Aluguel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AluguelRepository extends JpaRepository<Aluguel, String> {
    @Query("FROM Aluguel a " +
            "WHERE a.id = :id " +
            "AND a.deletedAt is null")
    Optional<Aluguel> getOne(Long id);
}
