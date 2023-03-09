package es.nosadd.nosadd.controller;

import es.nosadd.nosadd.util.Errores;
import es.nosadd.nosadd.util.Exitos;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import es.nosadd.nosadd.service.ActoresPeliculasService;
import es.nosadd.nosadd.model.ActoresPeliculas;
import es.nosadd.nosadd.dto.ActoresPeliculasDTO;

import java.util.List;

@RestController
@RequestMapping("api/actorespeliculas")
@Tag(name = "ActoresPeliculas", description = "API de actoresPeliculas")
public class ActoresPeliculasController {

    @Autowired
    private ActoresPeliculasService actoresPeliculasService;

    @PostMapping
    @Operation(summary = "Insertar un actoresPeliculas")
    public ResponseEntity<?> insertarActoresPeliculas(@RequestBody ActoresPeliculasDTO actoresPeliculasDTO) {

        ActoresPeliculas actoresPeliculasConsultado = actoresPeliculasService.findById(actoresPeliculasDTO.getId());

        if (actoresPeliculasConsultado == null) {
            actoresPeliculasService.save(actoresPeliculasDTO.toActoresPeliculas());
            return ResponseEntity.status(HttpStatus.CREATED).body(Exitos.ACTORESPELICULAS_CREADO);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Errores.ERROR_ACTORESPELICULAS_YA_EXISTE);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getActoresPeliculasById(@PathVariable int id) {
        ActoresPeliculas actoresPeliculas = actoresPeliculasService.findById(id);
        if (actoresPeliculas != null) {
            return ResponseEntity.status(HttpStatus.OK).body(actoresPeliculas);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_ACTORESPELICULAS_NO_ENCONTRADO);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllActoresPeliculass() {
        List<ActoresPeliculas> actoresPeliculass = actoresPeliculasService.findAll();
        if (actoresPeliculass != null && !actoresPeliculass.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(actoresPeliculass);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_ACTORESPELICULAS_NO_ENCONTRADOS);
        }
    }

    @GetMapping("/allByActorId/{actorId}")
    public ResponseEntity<?> getAllActoresPeliculassByActorId(@PathVariable int actorId) {
        List<ActoresPeliculas> actoresPeliculass = actoresPeliculasService.findAllByActorId(actorId);
        if (actoresPeliculass != null && !actoresPeliculass.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(actoresPeliculass);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_ACTORESPELICULAS_NO_ENCONTRADOS);
        }
    }

    @GetMapping("/allByPeliculaId/{peliculaId}")
    public ResponseEntity<?> getAllActoresPeliculassByPeliculaId(@PathVariable int peliculaId) {
        List<ActoresPeliculas> actoresPeliculass = actoresPeliculasService.findAllByPeliculaId(peliculaId);
        if (actoresPeliculass != null && !actoresPeliculass.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(actoresPeliculass);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_ACTORESPELICULAS_NO_ENCONTRADOS);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateActoresPeliculas(@PathVariable int id, @RequestBody ActoresPeliculasDTO actoresPeliculasDTO) {
        ActoresPeliculas actoresPeliculasConsultado = actoresPeliculasService.findById(id);
        if (actoresPeliculasConsultado != null) {
            actoresPeliculasService.save(actoresPeliculasDTO.toActoresPeliculas());
            return ResponseEntity.status(HttpStatus.OK).body(Exitos.ACTORESPELICULAS_EDITADO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_ACTORESPELICULAS_NO_ENCONTRADO);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteActoresPeliculas(@PathVariable int id) {
        ActoresPeliculas actoresPeliculasConsultado = actoresPeliculasService.findById(id);
        if (actoresPeliculasConsultado != null) {
            actoresPeliculasService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(Exitos.ACTORESPELICULAS_ELIMINADO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_ACTORESPELICULAS_NO_ENCONTRADO);
        }
    }
}
