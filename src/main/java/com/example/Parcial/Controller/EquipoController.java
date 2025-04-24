package com.example.Parcial.Controller;

import com.example.Parcial.Model.Equipo;
import com.example.Parcial.Service.EquipoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/equipos")
public class EquipoController {

    private final EquipoService equipoService;

    public EquipoController(EquipoService equipoService) {
        this.equipoService = equipoService;
    }

    @GetMapping
    public List<Equipo> getAllEquipos() {
        return equipoService.getAllEquipos();
    }

    @GetMapping("/{id}")
    public Optional<Equipo> getEquipoById(@PathVariable int id) {
        return equipoService.getEquipoById(id);
    }

    @PostMapping
    public Equipo createEquipo(@RequestBody Equipo equipo) {
        return equipoService.saveEquipo(equipo);
    }

    @PutMapping("/{id}")
    public Equipo updateEquipo(@PathVariable int id, @RequestBody Equipo equipo) {
        equipo.setId_equipo(id);
        return equipoService.saveEquipo(equipo);
    }

    @DeleteMapping("/{id}")
    public void deleteEquipo(@PathVariable int id) {
        equipoService.deleteEquipo(id);
    }
}
