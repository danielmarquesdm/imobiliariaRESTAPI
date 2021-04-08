package edu.ifma.lpweb.rest.imobiliaria.repository;

import edu.ifma.lpweb.rest.imobiliaria.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String> {
    @Query("FROM Cliente c " +
            "WHERE c.id = :id " +
            "AND c.deletedAt is null")
    Optional<Cliente> getOne(Long id);
}
