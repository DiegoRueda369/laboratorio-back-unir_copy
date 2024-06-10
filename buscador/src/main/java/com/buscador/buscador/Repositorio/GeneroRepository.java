package com.buscador.buscador.Repositorio;

import com.buscador.buscador.Entidad.Genero;
import com.buscador.buscador.Entidad.GeneroId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, GeneroId> {
    List<Genero> findByNameContaining(String name);

    @Query("SELECT MAX(g.id.id) FROM Genero g")
    Optional<Integer> findMaxId();


}
