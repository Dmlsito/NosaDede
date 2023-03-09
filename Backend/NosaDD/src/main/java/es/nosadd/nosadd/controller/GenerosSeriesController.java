package es.nosadd.nosadd.controller;

import es.nosadd.nosadd.util.Errores;
import es.nosadd.nosadd.util.Exitos;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import es.nosadd.nosadd.service.GenerosSeriesService;
import es.nosadd.nosadd.model.GenerosSeries;
import es.nosadd.nosadd.dto.GenerosSeriesDTO;

import java.util.List;

@RestController
@RequestMapping("api/generosseries")
@Tag(name = "GenerosSeries", description = "API de generosSeries")
public class GenerosSeriesController {

    @Autowired
    private GenerosSeriesService generosSeriesService;

    @PostMapping
    @Operation(summary = "Insertar un generosSeries")
    public ResponseEntity<?> insertarGenerosSeries(@RequestBody GenerosSeriesDTO generosSeriesDTO) {

        GenerosSeries generosSeriesConsultado = generosSeriesService.findById(generosSeriesDTO.getId());

        if (generosSeriesConsultado == null) {
            generosSeriesService.save(generosSeriesDTO.toGenerosSeries());
            return ResponseEntity.status(HttpStatus.CREATED).body(Exitos.GENEROSSERIES_CREADO);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Errores.ERROR_GENEROSSERIES_YA_EXISTE);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getGenerosSeriesById(@PathVariable int id) {
        GenerosSeries generosSeries = generosSeriesService.findById(id);
        if (generosSeries != null) {
            return ResponseEntity.status(HttpStatus.OK).body(generosSeries);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_GENEROSSERIES_NO_ENCONTRADO);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllGenerosSeriess() {
        List<GenerosSeries> generosSeriess = generosSeriesService.findAll();
        if (generosSeriess != null && !generosSeriess.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(generosSeriess);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_GENEROSSERIES_NO_ENCONTRADOS);
        }
    }

    @GetMapping("/idserie/{idserie}")
    public ResponseEntity<?> getGenerosSeriesByIdSerie(@PathVariable int idserie) {
        List<GenerosSeries> generosSeriess = generosSeriesService.findAllBySerieId(idserie);
        if (generosSeriess != null && !generosSeriess.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(generosSeriess);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_GENEROSSERIES_NO_ENCONTRADOS);
        }
    }

    @GetMapping("/idgenero/{idgenero}")
    public ResponseEntity<?> getGenerosSeriesByIdGenero(@PathVariable int idgenero) {
        List<GenerosSeries> generosSeriess = generosSeriesService.findAllByGeneroId(idgenero);
        if (generosSeriess != null && !generosSeriess.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(generosSeriess);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_GENEROSSERIES_NO_ENCONTRADOS);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateGenerosSeries(@PathVariable int id, @RequestBody GenerosSeriesDTO generosSeriesDTO) {
        GenerosSeries generosSeriesConsultado = generosSeriesService.findById(id);
        if (generosSeriesConsultado != null) {
            generosSeriesService.save(generosSeriesDTO.toGenerosSeries());
            return ResponseEntity.status(HttpStatus.OK).body(Exitos.GENEROSSERIES_EDITADO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_GENEROSSERIES_NO_ENCONTRADO);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteGenerosSeries(@PathVariable int id) {
        GenerosSeries generosSeriesConsultado = generosSeriesService.findById(id);
        if (generosSeriesConsultado != null) {
            generosSeriesService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(Exitos.GENEROSSERIES_ELIMINADO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_GENEROSSERIES_NO_ENCONTRADO);
        }
    }
}
