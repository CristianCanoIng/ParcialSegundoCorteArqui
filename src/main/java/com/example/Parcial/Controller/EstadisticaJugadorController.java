package com.example.Parcial.Controller;

import com.example.Parcial.Model.EstadisticaJugador;
import com.example.Parcial.Service.EstadisticaJugadorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estadisticas")
public class EstadisticaJugadorController {

    private final EstadisticaJugadorService estadisticaJugadorService;

    public EstadisticaJugadorController(EstadisticaJugadorService estadisticaJugadorService) {
        this.estadisticaJugadorService = estadisticaJugadorService;
    }

    @GetMapping
    public List<EstadisticaJugador> getAllEstadisticas() {
        return estadisticaJugadorService.getAllEstadisticas();
    }

    @GetMapping("/{id}")
    public Optional<EstadisticaJugador> getEstadisticaById(@PathVariable int id) {
        return estadisticaJugadorService.getEstadisticaById(id);
    }

    @PostMapping
    public EstadisticaJugador createEstadistica(@RequestBody EstadisticaJugador estadistica) {
        return estadisticaJugadorService.saveEstadistica(estadistica);
    }

    @PutMapping("/{id}")
    public EstadisticaJugador updateEstadistica(@PathVariable int id, @RequestBody EstadisticaJugador estadistica) {
        estadistica.setId_estadistica(id);
        return estadisticaJugadorService.saveEstadistica(estadistica);
    }

    @DeleteMapping("/{id}")
    public void deleteEstadistica(@PathVariable int id) {
        estadisticaJugadorService.deleteEstadistica(id);
    }
}
