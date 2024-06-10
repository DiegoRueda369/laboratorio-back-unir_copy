package com.buscador.buscador.Controlador;

import com.buscador.buscador.Entidad.Cast;
import com.buscador.buscador.Entidad.CastId;
import com.buscador.buscador.Servicio.CastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cast")
public class CastController {

    @Autowired
    private CastService castService;

    @GetMapping
    public List<Cast> getAllCasts() {
        return castService.findAll();
    }

    @GetMapping("/{idFilm}/{castId}/{castName}")
    public ResponseEntity<Cast> getCastById(@PathVariable Integer idFilm, @PathVariable Integer castId, @PathVariable String castName) {
        CastId castIdObj = new CastId(idFilm, castId, castName);
        Cast cast = castService.findById(castIdObj);
        if (cast != null) {
            return ResponseEntity.ok(cast);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Cast createCast(@RequestBody Cast cast) {
        return castService.save(cast);
    }

    @PutMapping("/{idFilm}/{castId}/{castName}")
    public ResponseEntity<Cast> updateCast(@PathVariable Integer idFilm, @PathVariable Integer castId, @PathVariable String castName, @RequestBody Cast castDetails) {
        CastId castIdObj = new CastId(idFilm, castId, castName);
        Cast updatedCast = castService.updateCast(castIdObj, castDetails);
        if (updatedCast != null) {
            return ResponseEntity.ok(updatedCast);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{idFilm}/{castId}/{castName}")
    public ResponseEntity<Void> deleteCast(@PathVariable Integer idFilm, @PathVariable Integer castId, @PathVariable String castName) {
        CastId castIdObj = new CastId(idFilm, castId, castName);
        castService.deleteById(castIdObj);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public List<Cast> searchCasts(@RequestParam String castName) {
        return castService.findByCastNameContaining(castName);
    }

}
