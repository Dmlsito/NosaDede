package es.nosadd.nosadd.controller;

import es.nosadd.nosadd.util.Errores;
import es.nosadd.nosadd.util.Exitos;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import es.nosadd.nosadd.service.DirectoresSeriesService;
import es.nosadd.nosadd.model.DirectoresSeries;
import es.nosadd.nosadd.dto.DirectoresSeriesDTO;

import java.util.List;

@RestController
@RequestMapping("api/directoresseries")
@Tag(name = "DirectoresSeries", description = "API de directoresSeries")
public class DirectoresSeriesController {

    @Autowired
    private DirectoresSeriesService directoresSeriesService;

    @PostMapping
    @Operation(summary = "Insertar un directoresSeries")
    public ResponseEntity<?> insertarDirectoresSeries(@RequestBody DirectoresSeriesDTO directoresSeriesDTO) {

        DirectoresSeries directoresSeriesConsultado = directoresSeriesService.findById(directoresSeriesDTO.getId());

        if (directoresSeriesConsultado == null) {
            directoresSeriesService.save(directoresSeriesDTO.toDirectoresSeries());
            return ResponseEntity.status(HttpStatus.CREATED).body(Exitos.DIRECTORESSERIES_CREADO);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Errores.ERROR_DIRECTORESSERIES_YA_EXISTE);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDirectoresSeriesById(@PathVariable int id) {
        DirectoresSeries directoresSeries = directoresSeriesService.findById(id);
        if (directoresSeries != null) {
            return ResponseEntity.status(HttpStatus.OK).body(directoresSeries);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_DIRECTORESSERIES_NO_ENCONTRADO);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllDirectoresSeriess() {
        List<DirectoresSeries> directoresSeriess = directoresSeriesService.findAll();
        if (directoresSeriess != null && !directoresSeriess.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(directoresSeriess);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_DIRECTORESSERIES_NO_ENCONTRADOS);
        }
    }

    @GetMapping("/idserie/{idserie}")
    public ResponseEntity<?> getDirectoresSeriesByIdSerie(@PathVariable int idserie) {
        List<DirectoresSeries> directoresSeriess = directoresSeriesService.findAllBySerieId(idserie);
        if (directoresSeriess != null && !directoresSeriess.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(directoresSeriess);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_DIRECTORESSERIES_NO_ENCONTRADOS);
        }
    }

    @GetMapping("/iddirector/{iddirector}")
    public ResponseEntity<?> getDirectoresSeriesByIdDirector(@PathVariable int iddirector) {
        List<DirectoresSeries> directoresSeriess = directoresSeriesService.findAllByDirectorId(iddirector);
        if (directoresSeriess != null && !directoresSeriess.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(directoresSeriess);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_DIRECTORESSERIES_NO_ENCONTRADOS);
        }
    }

    @PutMapping("/update/{id}")
    ResponseEntity<?> updateDirectoresSeries(@RequestBody DirectoresSeriesDTO directoresSeriesDTO, @PathVariable int id) {
        DirectoresSeries directoresSeriesConsultado = directoresSeriesService.findById(id);
        if (directoresSeriesConsultado != null) {
            directoresSeriesService.save(directoresSeriesDTO.toDirectoresSeries());
            return ResponseEntity.status(HttpStatus.OK).body(Exitos.DIRECTORESSERIES_EDITADO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_DIRECTORESSERIES_NO_ENCONTRADO);
        }
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<?> deleteDirectoresSeries(@PathVariable int id) {
        DirectoresSeries directoresSeriesConsultado = directoresSeriesService.findById(id);
        if (directoresSeriesConsultado != null) {
            directoresSeriesService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(Exitos.DIRECTORESSERIES_ELIMINADO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_DIRECTORESSERIES_NO_ENCONTRADO);
        }
    }
    
}
