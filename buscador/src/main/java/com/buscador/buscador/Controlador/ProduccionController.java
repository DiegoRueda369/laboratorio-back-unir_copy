package com.buscador.buscador.Controlador;

import com.buscador.buscador.Entidad.Produccion;
import com.buscador.buscador.Entidad.ProduccionId;
import com.buscador.buscador.Servicio.ProduccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produccion")
public class ProduccionController {

    @Autowired
    private ProduccionService produccionService;

    @GetMapping
    public List<Produccion> getAllProducciones() {
        return produccionService.findAll();
    }

    @GetMapping("/{idFilm}/{id}")
    public ResponseEntity<Produccion> getProduccionById(@PathVariable Integer idFilm, @PathVariable Integer id) {
        ProduccionId produccionId = new ProduccionId(idFilm, id);
        Produccion produccion = produccionService.findById(produccionId);
        if (produccion != null) {
            return ResponseEntity.ok(produccion);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Produccion createProduccion(@RequestBody Produccion produccion) {
        return produccionService.save(produccion);
    }

    @PutMapping("/{idFilm}/{id}")
    public ResponseEntity<Produccion> updateProduccion(@PathVariable Integer idFilm, @PathVariable Integer id, @RequestBody Produccion produccionDetails) {
        ProduccionId produccionId = new ProduccionId(idFilm, id);
        Produccion updatedProduccion = produccionService.updateProduccion(produccionId, produccionDetails);
        if (updatedProduccion != null) {
            return ResponseEntity.ok(updatedProduccion);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{idFilm}/{id}")
    public ResponseEntity<Void> deleteProduccion(@PathVariable Integer idFilm, @PathVariable Integer id) {
        ProduccionId produccionId = new ProduccionId(idFilm, id);
        produccionService.deleteById(produccionId);
        return ResponseEntity.noContent().build();
    }
}
