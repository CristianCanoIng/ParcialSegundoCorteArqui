package com.example.Parcial.Controller;

import com.example.Parcial.Model.Entrenador;
import com.example.Parcial.Service.EntrenadorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/entrenadores")
public class EntrenadorController {

    private final EntrenadorService entrenadorService;

    public EntrenadorController(EntrenadorService entrenadorService) {
        this.entrenadorService = entrenadorService;
    }

    @GetMapping
    public List<Entrenador> getAllEntrenadores() {
        return entrenadorService.getAllEntrenadores();
    }

    @GetMapping("/{id}")
    public Optional<Entrenador> getEntrenadorById(@PathVariable int id) {
        return entrenadorService.getEntrenadorById(id);
    }

    @PostMapping
    public Entrenador createEntrenador(@RequestBody Entrenador entrenador) {
        return entrenadorService.saveEntrenador(entrenador);
    }

    @PutMapping("/{id}")
    public Entrenador updateEntrenador(@PathVariable int id, @RequestBody Entrenador entrenador) {
        entrenador.setId_entrenador(id);
        return entrenadorService.saveEntrenador(entrenador);
    }

    @DeleteMapping("/{id}")
    public void deleteEntrenador(@PathVariable int id) {
        entrenadorService.deleteEntrenador(id);
    }
}
