package com.metaphorce.shopAll.controllers;

import com.metaphorce.shopAll.entidades.Pelicula;
import com.metaphorce.shopAll.excepciones.DatosNoValidosException;
import com.metaphorce.shopAll.services.PeliculaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/shopAll/peliculas")
public class PeliculaController {

    @Autowired
    private PeliculaService peliculaService;

    @GetMapping
    public ResponseEntity<List<Pelicula>> obtenerTodasLasPeliculas() {
        return ResponseEntity.ok(peliculaService.obtenerTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pelicula> obtenerPeliculaPorId(@PathVariable Integer id) {

        return ResponseEntity.ok(peliculaService.obtenerPorId(id));
    }

    @PostMapping
    // Devolverá lo que sea puede ser una lista de errores o con un objeto tipo pelicula
    public ResponseEntity<?> crearPelicula(@Valid @RequestBody Pelicula pelicula, BindingResult result) {
        if (result.hasErrors()) {
            // Lanzamos datosNoValidosException
            throw new DatosNoValidosException("Error de validacion", result);
        }
        return new ResponseEntity<>(peliculaService.guardar(pelicula), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pelicula> actualizarPelicula(@PathVariable Integer id, @Valid @RequestBody Pelicula pelicula) {
        Pelicula peliculaVerificacion = peliculaService.obtenerPorId(id);
        pelicula.setId(id);
        peliculaService.guardar(pelicula);

        return new ResponseEntity<>(peliculaService.guardar(pelicula), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPelicula(@PathVariable Integer id) {
        Pelicula peliculaVerificacion = peliculaService.obtenerPorId(id); // En este metodo de obtenerPorId se verifica que exista una pelicula con ese Id
        // Procedemos a hacer la eliminacion, con el id, si no hubiera Pelicula con ese Id se detiene antes de llegar aqui
        peliculaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
