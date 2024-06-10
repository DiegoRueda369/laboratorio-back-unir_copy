package com.buscador.buscador.Repositorio;

import com.buscador.buscador.Entidad.PaisRodaje;
import com.buscador.buscador.Entidad.PaisRodajeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRodajeRepository extends JpaRepository<PaisRodaje, PaisRodajeId> {
}
