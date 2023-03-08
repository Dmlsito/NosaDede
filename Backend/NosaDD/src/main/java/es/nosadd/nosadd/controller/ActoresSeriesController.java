package es.nosadd.nosadd.controller;

import es.nosadd.nosadd.service.ActoresSeriesService;
import es.nosadd.nosadd.util.Errores;
import es.nosadd.nosadd.util.Exitos;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import es.nosadd.nosadd.model.ActoresSeries;
import es.nosadd.nosadd.dto.ActoresSeriesDTO;

import java.util.List;

@RestController
@RequestMapping("api/actoresseries")
@Tag(name = "ActoresSeries", description = "API de actoresSeries")
public class ActoresSeriesController {

    @Autowired
    private ActoresSeriesService actoresSeriesService;

    @PostMapping
    @Operation(summary = "Insertar un actoresSeries")
    public ResponseEntity<?> insertarActoresSeries(@RequestBody ActoresSeriesDTO actoresSeriesDTO) {

        ActoresSeries actoresSeriesConsultado = actoresSeriesService.findById(actoresSeriesDTO.getId());

        if (actoresSeriesConsultado == null) {
            actoresSeriesService.save(actoresSeriesDTO.toActoresSeries());
            return ResponseEntity.status(HttpStatus.CREATED).body(Exitos.ACTORESSERIES_CREADO);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Errores.ERROR_ACTORESSERIES_YA_EXISTE);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getActoresSeriesById(@PathVariable int id) {
        ActoresSeries actoresSeries = actoresSeriesService.findById(id);
        if (actoresSeries != null) {
            return ResponseEntity.status(HttpStatus.OK).body(actoresSeries);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_ACTORESSERIES_NO_ENCONTRADO);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllActoresSeriess() {
        List<ActoresSeries> actoresSeriess = actoresSeriesService.findAll();
        if (actoresSeriess != null && !actoresSeriess.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(actoresSeriess);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_ACTORESSERIES_NO_ENCONTRADOS);
        }
    }

    @GetMapping("/idactor/{idActor}")
    public ResponseEntity<?> getActoresSeriesByIdActor(@PathVariable int idActor) {
        List<ActoresSeries> actoresSeriess = actoresSeriesService.findAllByActorId(idActor);
        if (actoresSeriess != null && !actoresSeriess.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(actoresSeriess);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_ACTORESSERIES_NO_ENCONTRADOS);
        }
    }

    @GetMapping("/idserie/{idSerie}")
    public ResponseEntity<?> getActoresSeriesByIdSerie(@PathVariable int idSerie) {
        List<ActoresSeries> actoresSeriess = actoresSeriesService.findAllBySerieId(idSerie);
        if (actoresSeriess != null && !actoresSeriess.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(actoresSeriess);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_ACTORESSERIES_NO_ENCONTRADOS);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateActoresSeries(@PathVariable int id, @RequestBody ActoresSeriesDTO actoresSeriesDTO) {
        ActoresSeries actoresSeriesConsultado = actoresSeriesService.findById(id);
        if (actoresSeriesConsultado != null) {
            actoresSeriesService.save(actoresSeriesDTO.toActoresSeries());
            return ResponseEntity.status(HttpStatus.OK).body(Exitos.ACTORESSERIES_EDITADO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_ACTORESSERIES_NO_ENCONTRADO);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteActoresSeries(@PathVariable int id) {
        ActoresSeries actoresSeriesConsultado = actoresSeriesService.findById(id);
        if (actoresSeriesConsultado != null) {
            actoresSeriesService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(Exitos.ACTORESSERIES_ELIMINADO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_ACTORESSERIES_NO_ENCONTRADO);
        }
    }

}
