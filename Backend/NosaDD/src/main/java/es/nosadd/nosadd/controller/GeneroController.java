package es.nosadd.nosadd.controller;

import es.nosadd.nosadd.util.Errores;
import es.nosadd.nosadd.util.Exitos;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import es.nosadd.nosadd.service.GeneroService;
import es.nosadd.nosadd.model.Genero;

import java.util.List;

@RestController
@RequestMapping("api/genero")
@Tag(name = "Genero", description = "API de genero")
public class GeneroController {

    @Autowired
    private GeneroService generoService;

    @PostMapping
    @Operation(summary = "Insertar un genero")
    public ResponseEntity<?> insertarGenero(@RequestBody Genero genero) {

        Genero generoConsultado = generoService.findById(genero.getId());

        if (generoConsultado == null) {
            generoService.save(genero);
            return ResponseEntity.status(HttpStatus.CREATED).body(Exitos.GENERO_CREADO);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Errores.ERROR_GENERO_YA_EXISTE);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getGenero(@PathVariable int id) {
        Genero genero = generoService.findById(id);
        if (genero != null) {
            return ResponseEntity.status(HttpStatus.OK).body(genero);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_GENERO_NO_ENCONTRADO);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllGeneros() {
        List<Genero> generos = generoService.findAll();
        if (generos != null && !generos.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(generos);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_GENEROS_NO_ENCONTRADOS);
        }
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<?> getGeneroByNombre(@PathVariable String nombre) {
        Genero genero = generoService.findByNombre(nombre);
        if (genero != null) {
            return ResponseEntity.status(HttpStatus.OK).body(genero);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_GENEROS_NO_ENCONTRADOS);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateGenero(@PathVariable int id, @RequestBody Genero genero) {
        Genero generoConsultado = generoService.findById(id);
        if (generoConsultado != null) {
            genero.setId(id);
            generoService.save(genero);
            return ResponseEntity.status(HttpStatus.OK).body(Exitos.GENERO_EDITADO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_GENERO_NO_ENCONTRADO);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteGenero(@PathVariable int id) {
        Genero generoConsultado = generoService.findById(id);
        if (generoConsultado != null) {
            generoService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(Exitos.GENERO_ELIMINADO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_GENERO_NO_ENCONTRADO);
        }
    }
}
