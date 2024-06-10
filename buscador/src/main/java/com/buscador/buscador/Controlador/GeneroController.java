package com.buscador.buscador.Controlador;

import com.buscador.buscador.Entidad.Genero;
import com.buscador.buscador.Entidad.GeneroId;
import com.buscador.buscador.Servicio.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/genero")
public class GeneroController {

    @Autowired
    private GeneroService generoService;

    @GetMapping
    public List<Genero> getAllGeneros() {
        return generoService.findAll();
    }
    @GetMapping("/top10")
    public List<Genero> getTopGeneros() {
        return generoService.getTop10Generos();
    }
    @GetMapping("/{idFilm}/{id}")
    public ResponseEntity<Genero> getGeneroById(@PathVariable Integer idFilm, @PathVariable Integer id) {
        GeneroId generoId = new GeneroId(idFilm, id);
        Genero genero = generoService.findById(generoId);
        if (genero != null) {
            return ResponseEntity.ok(genero);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Genero createGenero(@RequestBody Genero genero) {
        return generoService.save(genero);
    }

    @PutMapping("/{idFilm}/{id}")
    public ResponseEntity<Genero> updateGenero(@PathVariable Integer idFilm, @PathVariable Integer id, @RequestBody Genero generoDetails) {
        GeneroId generoId = new GeneroId(idFilm, id);
        Genero updatedGenero = generoService.updateGenero(generoId, generoDetails);
        if (updatedGenero != null) {
            return ResponseEntity.ok(updatedGenero);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{idFilm}/{id}")
    public ResponseEntity<Void> deleteGenero(@PathVariable Integer idFilm, @PathVariable Integer id) {
        GeneroId generoId = new GeneroId(idFilm, id);
        generoService.deleteById(generoId);
        return ResponseEntity.noContent().build();
    }
}
