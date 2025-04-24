package com.example.Parcial.Service;

import com.example.Parcial.Model.Jugador;
import com.example.Parcial.Repository.JugadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class JugadorService {
    private final JugadorRepository jugadorRepository;

    public JugadorService(JugadorRepository jugadorRepository) {
        this.jugadorRepository = jugadorRepository;
    }

    public List<Jugador> getAllJugadores() {
        return jugadorRepository.findAll();
    }

    public Optional<Jugador> getJugadorById(int id) {
        return jugadorRepository.findById(id);
    }

    public Jugador saveJugador(Jugador jugador) {
        return jugadorRepository.save(jugador);
    }

    public void deleteJugador(int id) {
        jugadorRepository.deleteById(id);
    }

    public List<Jugador> getJugadoresByEquipo(int id_equipo) {
        return jugadorRepository.findByEquipoId(id_equipo);
    }

    public List<Map<String, Object>> getJugadoresConMasDeXGoles(int goles) {
        return jugadorRepository.findJugadoresConMasGoles(goles);
    }
}
