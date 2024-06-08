package com.Operador.operador.Repositorio;

import com.Operador.operador.Entidad.Operacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RespositorioOperador extends JpaRepository<Operacion, Long> {
}