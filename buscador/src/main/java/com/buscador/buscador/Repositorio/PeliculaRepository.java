package com.buscador.buscador.Repositorio;

import com.buscador.buscador.Entidad.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, Integer> {
    @Query("SELECT MAX(p.id) FROM Pelicula p")
    Optional<Integer> findMaxId();
}
