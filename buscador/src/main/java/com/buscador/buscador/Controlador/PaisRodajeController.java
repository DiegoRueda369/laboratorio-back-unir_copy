package com.buscador.buscador.Controlador;

import com.buscador.buscador.Entidad.PaisRodaje;
import com.buscador.buscador.Entidad.PaisRodajeId;
import com.buscador.buscador.Servicio.PaisRodajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/paisRodaje")
public class PaisRodajeController {

    @Autowired
    private PaisRodajeService paisRodajeService;

    @GetMapping
    public List<PaisRodaje> getAllPaisRodaje() {
        return paisRodajeService.findAll();
    }

    @GetMapping("/{idFilm}/{pais}")
    public ResponseEntity<PaisRodaje> getPaisRodajeById(@PathVariable Integer idFilm, @PathVariable String pais) {
        PaisRodajeId paisRodajeId = new PaisRodajeId(idFilm, pais);
        PaisRodaje paisRodaje = paisRodajeService.findById(paisRodajeId);
        if (paisRodaje != null) {
            return ResponseEntity.ok(paisRodaje);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public PaisRodaje createPaisRodaje(@RequestBody PaisRodaje paisRodaje) {
        return paisRodajeService.save(paisRodaje);
    }

    @PutMapping("/{idFilm}/{pais}")
    public ResponseEntity<PaisRodaje> updatePaisRodaje(@PathVariable Integer idFilm, @PathVariable String pais, @RequestBody PaisRodaje paisRodajeDetails) {
        PaisRodajeId paisRodajeId = new PaisRodajeId(idFilm, pais);
        PaisRodaje updatedPaisRodaje = paisRodajeService.updatePaisRodaje(paisRodajeId, paisRodajeDetails);
        if (updatedPaisRodaje != null) {
            return ResponseEntity.ok(updatedPaisRodaje);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{idFilm}/{pais}")
    public ResponseEntity<Void> deletePaisRodaje(@PathVariable Integer idFilm, @PathVariable String pais) {
        PaisRodajeId paisRodajeId = new PaisRodajeId(idFilm, pais);
        paisRodajeService.deleteById(paisRodajeId);
        return ResponseEntity.noContent().build();
    }
}
