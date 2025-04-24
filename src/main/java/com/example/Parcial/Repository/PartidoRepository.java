package com.example.Parcial.Repository;

import com.example.Parcial.Model.Partido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface PartidoRepository extends JpaRepository<Partido, Integer> {

    //3
    @Query(value = """
    SELECT 
        e.nombre AS equipo,
        SUM(CASE WHEN p.equipo_local = e.id_equipo THEN p.goles_local
                 WHEN p.equipo_visita = e.id_equipo THEN p.goles_visita
                 ELSE 0 END) AS total_goles
    FROM equipo e
    JOIN partido p ON e.id_equipo = p.equipo_local OR e.id_equipo = p.equipo_visita
    WHERE e.id_equipo = :id_equipo
    GROUP BY e.nombre
""", nativeQuery = true)
    Map<String, Object> getTotalGolesEquipo(@Param("id_equipo") int id_equipo);

    //4
    @Query(value = """
    SELECT p.id_partido, p.fecha, p.estadio,
           el.nombre AS equipo_local,
           ev.nombre AS equipo_visita,
           p.goles_local, p.goles_visita
    FROM partido p
    JOIN equipo el ON p.equipo_local = el.id_equipo
    JOIN equipo ev ON p.equipo_visita = ev.id_equipo
    ORDER BY p.fecha DESC
""", nativeQuery = true)
    List<Map<String, Object>> getResultadosPartidos();

}
