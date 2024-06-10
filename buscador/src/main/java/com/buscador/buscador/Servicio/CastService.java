package com.buscador.buscador.Servicio;

import com.buscador.buscador.Entidad.Cast;
import com.buscador.buscador.Entidad.CastId;
import com.buscador.buscador.Repositorio.CastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CastService {

    @Autowired
    private CastRepository castRepository;

    public List<Cast> findAll() {
        return castRepository.findAll();
    }

    public Cast findById(CastId id) {
        return castRepository.findById(id).orElse(null);
    }

    public Cast save(Cast cast) {
        if (cast.getId().getCastId() == null) {
            Integer maxCastId = castRepository.findMaxCastId().orElse(0);
            cast.getId().setCastId(maxCastId + 1);
        }
        return castRepository.save(cast);
    }

    public void deleteById(CastId id) {
        castRepository.deleteById(id);
    }

    public Cast updateCast(CastId id, Cast castDetails) {
        Cast cast = findById(id);
        if (cast != null) {
            cast.setOriginalName(castDetails.getOriginalName());
            cast.setPopularity(castDetails.getPopularity());
            cast.setProfilePath(castDetails.getProfilePath());
            cast.setCharacter(castDetails.getCharacter());
            return save(cast);
        }
        return null;
    }

    public List<Cast> findByCastNameContaining(String castName) {
        return castRepository.findByIdCastNameContaining(castName);
    }
}
