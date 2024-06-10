package com.buscador.buscador.Servicio;

import com.buscador.buscador.Entidad.PaisRodaje;
import com.buscador.buscador.Entidad.PaisRodajeId;
import com.buscador.buscador.Repositorio.PaisRodajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaisRodajeService {

    @Autowired
    private PaisRodajeRepository paisRodajeRepository;

    public List<PaisRodaje> findAll() {
        return paisRodajeRepository.findAll();
    }

    public PaisRodaje findById(PaisRodajeId id) {
        return paisRodajeRepository.findById(id).orElse(null);
    }

    public PaisRodaje save(PaisRodaje paisRodaje) {
        return paisRodajeRepository.save(paisRodaje);
    }

    public void deleteById(PaisRodajeId id) {
        paisRodajeRepository.deleteById(id);
    }

    public PaisRodaje updatePaisRodaje(PaisRodajeId id, PaisRodaje paisRodajeDetails) {
        PaisRodaje paisRodaje = findById(id);
        if (paisRodaje != null) {
            paisRodaje.setId(paisRodajeDetails.getId());
            return save(paisRodaje);
        }
        return null;
    }
}
