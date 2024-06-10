package com.buscador.buscador.Repositorio;

import com.buscador.buscador.Entidad.Produccion;
import com.buscador.buscador.Entidad.ProduccionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProduccionRepository extends JpaRepository<Produccion, ProduccionId> {
    @Query("SELECT MAX(p.id.id) FROM Produccion p")
    Optional<Integer> findMaxId();
}
