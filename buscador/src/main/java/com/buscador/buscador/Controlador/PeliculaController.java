package com.buscador.buscador.Controlador;

import com.buscador.buscador.Entidad.Pelicula;
import com.buscador.buscador.Servicio.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pelicula")
public class PeliculaController {

    @Autowired
    private PeliculaService peliculaService;

    @GetMapping
    public List<Pelicula> getAllPeliculas() {
        return peliculaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pelicula> getPeliculaById(@PathVariable Integer id) {
        Pelicula pelicula = peliculaService.findById(id);
        if (pelicula != null) {
            return ResponseEntity.ok(pelicula);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Pelicula createPelicula(@RequestBody Pelicula pelicula) {
        return peliculaService.save(pelicula);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pelicula> updatePelicula(@PathVariable Integer id, @RequestBody Pelicula peliculaDetails) {
        Pelicula updatedPelicula = peliculaService.updatePelicula(id, peliculaDetails);
        if (updatedPelicula != null) {
            return ResponseEntity.ok(updatedPelicula);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePelicula(@PathVariable Integer id) {
        peliculaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
