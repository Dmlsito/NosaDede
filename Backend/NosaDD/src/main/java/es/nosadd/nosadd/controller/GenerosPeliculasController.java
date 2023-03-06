package es.nosadd.nosadd.controller;

import es.nosadd.nosadd.util.Errores;
import es.nosadd.nosadd.util.Exitos;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import es.nosadd.nosadd.service.GenerosPeliculasService;
import es.nosadd.nosadd.model.GenerosPeliculas;
import es.nosadd.nosadd.dto.GenerosPeliculasDTO;

import java.util.List;

@RestController
@RequestMapping("api/generospeliculas")
@Tag(name = "GenerosPeliculas", description = "API de generosPeliculas")
public class GenerosPeliculasController {

    @Autowired
    private GenerosPeliculasService generosPeliculasService;

    @PostMapping
    @Operation(summary = "Insertar un generosPeliculas")
    public ResponseEntity<?> insertarGenerosPeliculas(@RequestBody GenerosPeliculasDTO generosPeliculasDTO) {

        GenerosPeliculas generosPeliculasConsultado = generosPeliculasService.findById(generosPeliculasDTO.getId());

        if (generosPeliculasConsultado == null) {
            generosPeliculasService.save(generosPeliculasDTO.toGenerosPeliculas());
            return ResponseEntity.status(HttpStatus.CREATED).body(Exitos.GENEROSPELICULAS_CREADO);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Errores.ERROR_GENEROSPELICULAS_YA_EXISTE);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getGenerosPeliculasById(@PathVariable int id) {
        GenerosPeliculas generosPeliculas = generosPeliculasService.findById(id);
        if (generosPeliculas != null) {
            return ResponseEntity.status(HttpStatus.OK).body(generosPeliculas);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_GENEROSPELICULAS_NO_ENCONTRADO);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllGenerosPeliculass() {
        List<GenerosPeliculas> generosPeliculass = generosPeliculasService.findAll();
        if (generosPeliculass != null && !generosPeliculass.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(generosPeliculass);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_GENEROSPELICULAS_NO_ENCONTRADOS);
        }
    }

    @GetMapping("/idgenero/{idgenero}")
    public ResponseEntity<?> getGenerosPeliculasByIdGenero(@PathVariable int idgenero) {
        List<GenerosPeliculas> generosPeliculas = generosPeliculasService.findAllByGeneroId(idgenero);
        if (generosPeliculas != null && !generosPeliculas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(generosPeliculas);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_GENEROSPELICULAS_NO_ENCONTRADOS);
        }
    }

    @GetMapping("/idpelicula/{idpelicula}")
    public ResponseEntity<?> getGenerosPeliculasByIdPelicula(@PathVariable int idpelicula) {
        List<GenerosPeliculas> generosPeliculas = generosPeliculasService.findAllByPeliculaId(idpelicula);
        if (generosPeliculas != null && !generosPeliculas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(generosPeliculas);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_GENEROSPELICULAS_NO_ENCONTRADOS);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateGenerosPeliculas(@PathVariable int id, @RequestBody GenerosPeliculasDTO generosPeliculasDTO) {
        GenerosPeliculas generosPeliculasConsultado = generosPeliculasService.findById(id);
        if (generosPeliculasConsultado != null) {
            generosPeliculasService.save(generosPeliculasDTO.toGenerosPeliculas());
            return ResponseEntity.status(HttpStatus.OK).body(Exitos.GENEROSPELICULAS_EDITADO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_GENEROSPELICULAS_NO_ENCONTRADO);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteGenerosPeliculas(@PathVariable int id) {
        GenerosPeliculas generosPeliculasConsultado = generosPeliculasService.findById(id);
        if (generosPeliculasConsultado != null) {
            generosPeliculasService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(Exitos.GENEROSPELICULAS_ELIMINADO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_GENEROSPELICULAS_NO_ENCONTRADO);
        }
    }

}
