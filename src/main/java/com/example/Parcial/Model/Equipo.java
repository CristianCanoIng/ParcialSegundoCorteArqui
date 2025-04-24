package com.example.Parcial.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_equipo;

    @Column(length = 100)
    private String nombre;

    @Column(length = 100)
    private String ciudad;
    private Date fundacion;

    @OneToMany(mappedBy = "equipo", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Jugador> jugadores;

    @OneToMany(mappedBy = "equipo", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Entrenador> entrenadores;

    public Equipo() {}

    public Equipo(int id_equipo, String nombre, String ciudad, Date fundacion) {
        this.id_equipo = id_equipo;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.fundacion = fundacion;
    }

    public int getId_equipo() { return id_equipo; }
    public void setId_equipo(int id_equipo) { this.id_equipo = id_equipo; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }
    public Date getFundacion() { return fundacion; }
    public void setFundacion(Date fundacion) { this.fundacion = fundacion; }

    @Override
    public String toString() {
        return "Equipo{" +
                "id_equipo=" + id_equipo +
                ", nombre='" + nombre + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", fundacion=" + fundacion +
                '}';
    }
}
