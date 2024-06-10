package com.buscador.buscador.Servicio;

import com.buscador.buscador.Entidad.Genero;
import com.buscador.buscador.Entidad.GeneroId;
import com.buscador.buscador.Repositorio.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneroService {

    @Autowired
    private GeneroRepository generoRepository;

    public List<Genero> findAll() {
        return generoRepository.findAll();
    }

    public Genero findById(GeneroId id) {
        return generoRepository.findById(id).orElse(null);
    }

    public Genero save(Genero genero) {
        if (genero.getId().getId() == null) {
            Integer maxId = generoRepository.findMaxId().orElse(0);
            genero.getId().setId(maxId + 1);
        }
        return generoRepository.save(genero);
    }

    public void deleteById(GeneroId id) {
        generoRepository.deleteById(id);
    }

    public List<Genero> findByName(String name) {
        return generoRepository.findByNameContaining(name);
    }

    public Genero updateGenero(GeneroId id, Genero generoDetails) {
        Genero genero = findById(id);
        if (genero != null) {
            genero.setName(generoDetails.getName());
            return save(genero);
        }
        return null;
    }
    public List<Genero> getTop10Generos() {
        Page<Genero> page = generoRepository.findAll(PageRequest.of(0, 10));
        return page.getContent();
    }
}
