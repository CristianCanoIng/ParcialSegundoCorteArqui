package com.example.Parcial.Service;

import com.example.Parcial.Model.EstadisticaJugador;
import com.example.Parcial.Repository.EstadisticaJugadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadisticaJugadorService {
    private final EstadisticaJugadorRepository estadisticaJugadorRepository;

    public EstadisticaJugadorService(EstadisticaJugadorRepository estadisticaJugadorRepository) {
        this.estadisticaJugadorRepository = estadisticaJugadorRepository;
    }

    public List<EstadisticaJugador> getAllEstadisticas() {
        return estadisticaJugadorRepository.findAll();
    }

    public Optional<EstadisticaJugador> getEstadisticaById(int id) {
        return estadisticaJugadorRepository.findById(id);
    }

    public EstadisticaJugador saveEstadistica(EstadisticaJugador estadistica) {
        return estadisticaJugadorRepository.save(estadistica);
    }

    public void deleteEstadistica(int id) {
        estadisticaJugadorRepository.deleteById(id);
    }
}
