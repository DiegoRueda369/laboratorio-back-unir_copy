package com.buscador.buscador.Repositorio;

import com.buscador.buscador.Entidad.Cast;
import com.buscador.buscador.Entidad.CastId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CastRepository extends JpaRepository<Cast, CastId> {
    @Query("SELECT MAX(c.id.castId) FROM Cast c")
    Optional<Integer> findMaxCastId();

    List<Cast> findByIdCastNameContaining(String castName);


}
