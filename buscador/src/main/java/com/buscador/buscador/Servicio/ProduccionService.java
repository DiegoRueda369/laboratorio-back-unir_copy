package com.buscador.buscador.Servicio;

import com.buscador.buscador.Entidad.Produccion;
import com.buscador.buscador.Entidad.ProduccionId;
import com.buscador.buscador.Repositorio.ProduccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduccionService {

    @Autowired
    private ProduccionRepository produccionRepository;

    public List<Produccion> findAll() {
        return produccionRepository.findAll();
    }

    public Produccion findById(ProduccionId id) {
        return produccionRepository.findById(id).orElse(null);
    }

    public Produccion save(Produccion produccion) {
        if (produccion.getId().getId() == null) {
            Integer maxId = produccionRepository.findMaxId().orElse(0);
            produccion.getId().setId(maxId + 1);
        }
        return produccionRepository.save(produccion);
    }

    public void deleteById(ProduccionId id) {
        produccionRepository.deleteById(id);
    }

    public Produccion updateProduccion(ProduccionId id, Produccion produccionDetails) {
        Produccion produccion = findById(id);
        if (produccion != null) {
            produccion.setLogoPath(produccionDetails.getLogoPath());
            produccion.setName(produccionDetails.getName());
            return save(produccion);
        }
        return null;
    }
}
