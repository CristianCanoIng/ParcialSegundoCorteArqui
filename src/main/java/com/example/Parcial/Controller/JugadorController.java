package com.example.Parcial.Controller;

import com.example.Parcial.Model.Jugador;
import com.example.Parcial.Service.JugadorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/jugadores")
public class JugadorController {

    private final JugadorService jugadorService;

    public JugadorController(JugadorService jugadorService) {
        this.jugadorService = jugadorService;
    }

    @GetMapping
    public List<Jugador> getAllJugadores() {
        return jugadorService.getAllJugadores();
    }

    @GetMapping("/{id}")
    public Optional<Jugador> getJugadorById(@PathVariable int id) {
        return jugadorService.getJugadorById(id);
    }

    @PostMapping
    public Jugador createJugador(@RequestBody Jugador jugador) {
        return jugadorService.saveJugador(jugador);
    }

    @PutMapping("/{id}")
    public Jugador updateJugador(@PathVariable int id, @RequestBody Jugador jugador) {
        jugador.setId_jugador(id);
        return jugadorService.saveJugador(jugador);
    }

    @DeleteMapping("/{id}")
    public void deleteJugador(@PathVariable int id) {
        jugadorService.deleteJugador(id);
    }

    //1
    @GetMapping("/equipo/{id_equipo}")
    public List<Jugador> getJugadoresByEquipo(@PathVariable int id_equipo) {
        return jugadorService.getJugadoresByEquipo(id_equipo);
    }

    //2
    @GetMapping("/goles-mayor/{goles}")
    public List<Map<String, Object>> getJugadoresConMasDeXGoles(@PathVariable int goles) {
        return jugadorService.getJugadoresConMasDeXGoles(goles);
    }
}
