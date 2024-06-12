package com.Operador.operador.Repositorio;

import com.Operador.operador.Entidad.Transaccion;
import com.Operador.operador.Entidad.TransaccionId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransaccionRepository extends JpaRepository<Transaccion, TransaccionId> {
}
