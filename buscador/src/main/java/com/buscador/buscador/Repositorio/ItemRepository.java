package com.buscador.buscador.Repositorio;

import com.buscador.buscador.Entidad.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {
    List<Item> findByNombreContaining(String nombre);
}
