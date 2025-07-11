package com.metaphorce.shopAll.services;

import com.metaphorce.shopAll.entidades.Pelicula;

import java.util.List;
import java.util.Optional;

public interface PeliculaService {
    List<Pelicula> obtenerTodas();

    Optional<Pelicula> obtenerPorId(Integer id);

    Pelicula guardar(Pelicula pelicula);

    void eliminar(Integer id);
}
