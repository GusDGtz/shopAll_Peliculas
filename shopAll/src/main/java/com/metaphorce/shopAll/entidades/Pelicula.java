package com.metaphorce.shopAll.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Pelicula")
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "La pelicula debe contener un nombre")
    @NotNull(message = "La pelicula no puede ser nula")
    private String nombre = null;
    @NotEmpty(message = "El director debe contener un nombre")
    @NotNull(message = "El director no puede ser nulo")
    private String director = null;
    private boolean disponible = true; // En caso de no agregarse se marcará disponible
    @Min(value = 40, message = "La pelicula debe durar mas de 40 minutos")
    @NotNull(message = "La duracion no puede ser nula")
    private Long duracion = null;

    public Pelicula() {
    }

    public Pelicula(Integer id, String nombre, String director, boolean disponible, Long duracion) {
        this.id = id;
        this.nombre = nombre;
        this.director = director;
        this.disponible = disponible;
        this.duracion = duracion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String setDirector(String director) {
        return this.director = director;
    }

    public String getDirector() {
        return director;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public Long getDuracion() {
        return duracion;
    }

    public void setDuracion(Long duracion) {
        this.duracion = duracion;
    }
}
