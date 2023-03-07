package es.nosadd.nosadd.controller;

import es.nosadd.nosadd.util.Errores;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import es.nosadd.nosadd.service.PeliculaService;
import es.nosadd.nosadd.model.Pelicula;
import es.nosadd.nosadd.dto.PeliculaDTO;

import java.util.List;

@RestController
@RequestMapping("api/pelicula")
@Tag(name = "Pelicula", description = "API de pelicula")
public class PeliculaController {

    @Autowired
    private PeliculaService peliculaService;

    @PostMapping
    @Operation(summary = "Insertar una pelicula")
    public ResponseEntity<?> insertarPelicula(@RequestBody PeliculaDTO peliculaDTO) {

        Pelicula peliculaConsultada = peliculaService.findById(peliculaDTO.toPelicula().getId());

        if (peliculaConsultada == null) {
            peliculaService.save(peliculaDTO.toPelicula());
            return ResponseEntity.status(HttpStatus.CREATED).body(Exitos.PELICULA_CREADA);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Errores.ERROR_PELICULA_YA_EXISTE);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPelicula(@PathVariable int id) {
        Pelicula pelicula = peliculaService.findById(id);
        if (pelicula != null) {
            return ResponseEntity.status(HttpStatus.OK).body(pelicula);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_PELICULA_NO_ENCONTRADA);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllPeliculas() {
        List<Pelicula> peliculas = peliculaService.findAll();
        if (peliculas != null && !peliculas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(peliculas);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_PELICULAS_NO_ENCONTRADAS);
        }
    }

    @GetMapping("/all/titulo/{titulo}")
    public ResponseEntity<?> getPeliculaByTitulo(@PathVariable String titulo) {
        List<Pelicula> peliculas = peliculaService.findAllByTitulo(titulo);
        if (peliculas != null && !peliculas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(peliculas);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_PELICULAS_NO_ENCONTRADAS);
        }
    }

    @GetMapping("/all/valoracion/{valoracion}")
    public ResponseEntity<?> getPeliculaByValoracion(@PathVariable int valoracion) {
        List<Pelicula> peliculas = peliculaService.findAllByValoracion(valoracion);
        if (peliculas != null && !peliculas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(peliculas);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_PELICULAS_NO_ENCONTRADAS);
        }
    }

    @GetMapping("/all/valoracion/mayor/{valoracion}")
    public ResponseEntity<?> getPeliculaByValoracionMayor(@PathVariable int valoracion) {
        List<Pelicula> peliculas = peliculaService.findAllByValoracionGreaterThan(valoracion);
        if (peliculas != null && !peliculas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(peliculas);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_PELICULAS_NO_ENCONTRADAS);
        }
    }

    @GetMapping("/all/valoracion/menor/{valoracion}")
    public ResponseEntity<?> getPeliculaByValoracionMenor(@PathVariable int valoracion) {
        List<Pelicula> peliculas = peliculaService.findAllByValoracionLessThan(valoracion);
        if (peliculas != null && !peliculas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(peliculas);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_PELICULAS_NO_ENCONTRADAS);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updatePelicula(@PathVariable int id, @RequestBody PeliculaDTO peliculaDTO) {
        Pelicula peliculaConsultada = peliculaService.findById(id);
        if (peliculaConsultada != null) {
            peliculaService.save(peliculaDTO.toPelicula());
            return ResponseEntity.status(HttpStatus.OK).body(Exitos.PELICULA_EDITADA);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_PELICULA_NO_ENCONTRADA);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePelicula(@PathVariable int id) {
        Pelicula peliculaConsultada = peliculaService.findById(id);
        if (peliculaConsultada != null) {
            peliculaService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(Exitos.PELICULA_ELIMINADA);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_PELICULA_NO_ENCONTRADA);
        }
    }
}
