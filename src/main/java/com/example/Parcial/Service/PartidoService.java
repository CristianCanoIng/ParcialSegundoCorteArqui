package com.example.Parcial.Service;

import com.example.Parcial.Model.Partido;
import com.example.Parcial.Repository.PartidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PartidoService {
    private final PartidoRepository partidoRepository;

    public PartidoService(PartidoRepository partidoRepository) {
        this.partidoRepository = partidoRepository;
    }

    public List<Partido> getAllPartidos() {
        return partidoRepository.findAll();
    }

    public Optional<Partido> getPartidoById(int id) {
        return partidoRepository.findById(id);
    }

    public Partido savePartido(Partido partido) {
        return partidoRepository.save(partido);
    }

    public void deletePartido(int id) {
        partidoRepository.deleteById(id);
    }

    public Map<String, Object> getTotalGolesPorEquipo(int id_equipo) {
        return partidoRepository.getTotalGolesEquipo(id_equipo);
    }

    public List<Map<String, Object>> getResultadosDePartidos() {
        return partidoRepository.getResultadosPartidos();
    }
}
