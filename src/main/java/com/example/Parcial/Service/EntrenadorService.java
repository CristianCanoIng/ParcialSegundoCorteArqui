package com.example.Parcial.Service;

import com.example.Parcial.Model.Entrenador;
import com.example.Parcial.Repository.EntrenadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntrenadorService {
    private final EntrenadorRepository entrenadorRepository;

    public EntrenadorService(EntrenadorRepository entrenadorRepository) {
        this.entrenadorRepository = entrenadorRepository;
    }

    public List<Entrenador> getAllEntrenadores() {
        return entrenadorRepository.findAll();
    }

    public Optional<Entrenador> getEntrenadorById(int id) {
        return entrenadorRepository.findById(id);
    }

    public Entrenador saveEntrenador(Entrenador entrenador) {
        return entrenadorRepository.save(entrenador);
    }

    public void deleteEntrenador(int id) {
        entrenadorRepository.deleteById(id);
    }
}
