package edu.ifma.lpweb.rest.imobiliaria.repository;

import edu.ifma.lpweb.rest.imobiliaria.model.Imovel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImovelRepository extends JpaRepository<Imovel, String> {
    @Query("FROM Imovel i " +
            "WHERE i.id = :id " +
            "AND i.deletedAt is null")
    Optional<Imovel> getOne(Long id);
}
