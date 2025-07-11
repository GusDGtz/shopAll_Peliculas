package com.metaphorce.shopAll.controllers;

import com.metaphorce.shopAll.entidades.Pelicula;
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
        return peliculaService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    // Devolverá lo que sea puede ser una lista de errores o con un objeto tipo pelicula
    public ResponseEntity<?> crearPelicula(@Valid @RequestBody Pelicula pelicula, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errores = new HashMap<>(); // List <String> errores = new ArrayList<>();
            // Recorremos la lista de los errores en result y lo pasamos por parametro
            result.getFieldErrors().forEach(fieldError -> errores.put(fieldError.getField(), fieldError.getDefaultMessage()));
            return ResponseEntity.badRequest().body(errores); // default '.body(null)' cambiamos a la lista
        }
        return new ResponseEntity<>(peliculaService.guardar(pelicula), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pelicula> actualizarPelicula(@PathVariable Integer id, @Valid @RequestBody Pelicula pelicula) {
        return peliculaService.obtenerPorId(id)
                .map(peliculaExistente -> {
                    pelicula.setId(id);
                    return ResponseEntity.ok(peliculaService.guardar(pelicula));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPelicula(@PathVariable Integer id) {
        return peliculaService.obtenerPorId(id)
                .map(pelicula -> {
                    peliculaService.eliminar(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
