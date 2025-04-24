package com.example.Parcial.Controller;

import com.example.Parcial.Model.Partido;
import com.example.Parcial.Service.PartidoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/partidos")
public class PartidoController {

    private final PartidoService partidoService;

    public PartidoController(PartidoService partidoService) {
        this.partidoService = partidoService;
    }

    @GetMapping
    public List<Partido> getAllPartidos() {
        return partidoService.getAllPartidos();
    }

    @GetMapping("/{id}")
    public Optional<Partido> getPartidoById(@PathVariable int id) {
        return partidoService.getPartidoById(id);
    }

    @PostMapping
    public Partido createPartido(@RequestBody Partido partido) {
        return partidoService.savePartido(partido);
    }

    @PutMapping("/{id}")
    public Partido updatePartido(@PathVariable int id, @RequestBody Partido partido) {
        partido.setId_partido(id);
        return partidoService.savePartido(partido);
    }

    @DeleteMapping("/{id}")
    public void deletePartido(@PathVariable int id) {
        partidoService.deletePartido(id);
    }

    //3
    @GetMapping("/total-goles-equipo/{id_equipo}")
    public Map<String, Object> getTotalGolesEquipo(@PathVariable int id_equipo) {
        return partidoService.getTotalGolesPorEquipo(id_equipo);
    }

    //4
    @GetMapping("/resultados")
    public List<Map<String, Object>> getResultadosPartidos() {
        return partidoService.getResultadosDePartidos();
    }
}
