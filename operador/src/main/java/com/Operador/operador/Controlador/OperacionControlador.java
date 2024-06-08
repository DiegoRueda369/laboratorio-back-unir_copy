package com.Operador.operador.Controlador;

import com.Operador.operador.Entidad.Operacion;
import com.Operador.operador.Repositorio.RespositorioOperador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/operaciones")
public class OperacionControlador {
    @Autowired
    private RespositorioOperador repos;

    @GetMapping
    public List<Operacion> getAllOperaciones() {
        return repos.findAll();
    }

    @PostMapping
    public Operacion createOperacion(@RequestBody Operacion operacion) {
        return repos.save(operacion);
    }

    @PutMapping("/{id}")
    public Operacion updateOperacion(@PathVariable Long id, @RequestBody Operacion operacionDetails) {
        Operacion operacion = repos.findById(id).orElseThrow();
        operacion.setDescripcion(operacionDetails.getDescripcion());
        operacion.setFecha(operacionDetails.getFecha());
        return repos.save(operacion);
    }

    @DeleteMapping("/{id}")
    public void deleteOperacion(@PathVariable Long id) {
        repos.deleteById(id);
    }
}
