package com.metaphorce.shopAll.services;

import com.metaphorce.shopAll.entidades.Pelicula;

import java.util.List;

public interface PeliculaService {
    List<Pelicula> obtenerTodas();

    Pelicula obtenerPorId(Integer id);

    Pelicula guardar(Pelicula pelicula);

    void eliminar(Integer id);
}
