package com.metaphorce.shopAll.services;

import com.metaphorce.shopAll.entidades.Pelicula;
import com.metaphorce.shopAll.repositories.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeliculaServiceImpl implements PeliculaService {

    @Autowired
    PeliculaRepository peliculaRepository;

    @Override
    public List<Pelicula> obtenerTodas() {
        return peliculaRepository.findAll();
    }

    @Override
    public Optional<Pelicula> obtenerPorId(Integer id) {
        return peliculaRepository.findById(id);
    }

    @Override
    public Pelicula guardar(Pelicula pelicula) {
        return peliculaRepository.save(pelicula);
    }

    @Override
    public void eliminar(Integer id) {
        peliculaRepository.deleteById(id);
    }
}
