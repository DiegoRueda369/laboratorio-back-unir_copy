package com.buscador.buscador.Servicio;

import com.buscador.buscador.Entidad.Pelicula;
import com.buscador.buscador.Repositorio.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeliculaService {

    @Autowired
    private PeliculaRepository peliculaRepository;

    public List<Pelicula> findAll() {
        return peliculaRepository.findAll();
    }

    public Pelicula findById(Integer id) {
        return peliculaRepository.findById(id).orElse(null);
    }

    public Pelicula save(Pelicula pelicula) {
        if (pelicula.getId() == null) {
            Integer maxId = peliculaRepository.findMaxId().orElse(0);
            pelicula.setId(maxId + 1);
        }
        return peliculaRepository.save(pelicula);
    }

    public void deleteById(Integer id) {
        peliculaRepository.deleteById(id);
    }

    public Pelicula updatePelicula(Integer id, Pelicula peliculaDetails) {
        Pelicula pelicula = findById(id);
        if (pelicula != null) {
            pelicula.setTitle(peliculaDetails.getTitle());
            pelicula.setBackdropPath(peliculaDetails.getBackdropPath());
            pelicula.setPosterPath(peliculaDetails.getPosterPath());
            pelicula.setBudget(peliculaDetails.getBudget());
            pelicula.setOriginalLanguage(peliculaDetails.getOriginalLanguage());
            pelicula.setOriginalTitle(peliculaDetails.getOriginalTitle());
            pelicula.setPopularity(peliculaDetails.getPopularity());
            pelicula.setReleaseDate(peliculaDetails.getReleaseDate());
            pelicula.setRevenue(peliculaDetails.getRevenue());
            pelicula.setRuntime(peliculaDetails.getRuntime());
            pelicula.setTagline(peliculaDetails.getTagline());
            pelicula.setVoteAverage(peliculaDetails.getVoteAverage());
            pelicula.setVoteCount(peliculaDetails.getVoteCount());
            pelicula.setOverview(peliculaDetails.getOverview());
            return save(pelicula);
        }
        return null;
    }
}
