package com.example.Parcial.Repository;

import com.example.Parcial.Model.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Integer> {

    //1
    @Query(value = "SELECT * FROM jugador WHERE id_equipo = :id_equipo", nativeQuery = true)
    List<Jugador> findByEquipoId(@Param("id_equipo") int id_equipo);

    //2
    @Query(value = """
    SELECT 
        j.id_jugador, 
        j.nombre, 
        j.posicion, 
        j.dorsal, 
        j.fecha_nac, 
        j.nacionalidad, 
        j.id_equipo,
        SUM(e.goles) AS total_goles
    FROM jugador j
    JOIN estadistica_jugador e ON j.id_jugador = e.id_jugador
    GROUP BY j.id_jugador, j.nombre, j.posicion, j.dorsal, j.fecha_nac, j.nacionalidad, j.id_equipo
    HAVING SUM(e.goles) > :goles
    ORDER BY total_goles DESC
""", nativeQuery = true)
    List<Map<String, Object>> findJugadoresConMasGoles(@Param("goles") int goles);
}
