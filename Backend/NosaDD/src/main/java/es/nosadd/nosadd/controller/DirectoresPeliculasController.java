package es.nosadd.nosadd.controller;

import es.nosadd.nosadd.util.Errores;
import es.nosadd.nosadd.util.Exitos;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import es.nosadd.nosadd.service.DirectoresPeliculasService;
import es.nosadd.nosadd.model.DirectoresPeliculas;
import es.nosadd.nosadd.dto.DirectoresPeliculasDTO;

import java.util.List;

@RestController
@RequestMapping("api/directorespeliculas")
@Tag(name = "DirectoresPeliculas", description = "API de directoresPeliculas")
public class DirectoresPeliculasController {

    @Autowired
    private DirectoresPeliculasService directoresPeliculasService;

    @PostMapping
    @Operation(summary = "Insertar un directoresPeliculas")
    public ResponseEntity<?> insertarDirectoresPeliculas(@RequestBody DirectoresPeliculasDTO directoresPeliculasDTO) {

        DirectoresPeliculas directoresPeliculasConsultado = directoresPeliculasService.findById(directoresPeliculasDTO.getId());

        if (directoresPeliculasConsultado == null) {
            directoresPeliculasService.save(directoresPeliculasDTO.toDirectoresPeliculas());
            return ResponseEntity.status(HttpStatus.CREATED).body(Exitos.DIRECTORESPELICULAS_CREADO);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Errores.ERROR_DIRECTORESPELICULAS_YA_EXISTE);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDirectoresPeliculasById(@PathVariable int id) {
        DirectoresPeliculas directoresPeliculas = directoresPeliculasService.findById(id);
        if (directoresPeliculas != null) {
            return ResponseEntity.status(HttpStatus.OK).body(directoresPeliculas);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_DIRECTORESPELICULAS_NO_ENCONTRADO);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllDirectoresPeliculass() {
        List<DirectoresPeliculas> directoresPeliculass = directoresPeliculasService.findAll();
        if (directoresPeliculass != null && !directoresPeliculass.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(directoresPeliculass);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_DIRECTORESPELICULAS_NO_ENCONTRADOS);
        }
    }

    @GetMapping("/allByDirectorId/{directorId}")
    public ResponseEntity<?> getAllDirectoresPeliculassByDirectorId(@PathVariable int directorId) {
        List<DirectoresPeliculas> directoresPeliculass = directoresPeliculasService.findAllByDirectorId(directorId);
        if (directoresPeliculass != null && !directoresPeliculass.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(directoresPeliculass);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_DIRECTORESPELICULAS_NO_ENCONTRADOS);
        }
    }

    @GetMapping("/allByPeliculaId/{peliculaId}")
    public ResponseEntity<?> getAllDirectoresPeliculassByPeliculaId(@PathVariable int peliculaId) {
        List<DirectoresPeliculas> directoresPeliculass = directoresPeliculasService.findAllByPeliculaId(peliculaId);
        if (directoresPeliculass != null && !directoresPeliculass.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(directoresPeliculass);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_DIRECTORESPELICULAS_NO_ENCONTRADOS);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> actualizarDirectoresPeliculas(@PathVariable int id, @RequestBody DirectoresPeliculasDTO directoresPeliculasDTO) {
        DirectoresPeliculas directoresPeliculasConsultado = directoresPeliculasService.findById(id);
        if (directoresPeliculasConsultado != null) {
            directoresPeliculasService.save(directoresPeliculasDTO.toDirectoresPeliculas());
            return ResponseEntity.status(HttpStatus.OK).body(Exitos.DIRECTORESPELICULAS_EDITADO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_DIRECTORESPELICULAS_NO_ENCONTRADO);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteDirectoresPeliculas(@PathVariable int id) {
        DirectoresPeliculas directoresPeliculasConsultado = directoresPeliculasService.findById(id);
        if (directoresPeliculasConsultado != null) {
            directoresPeliculasService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(Exitos.DIRECTORESPELICULAS_ELIMINADO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_DIRECTORESPELICULAS_NO_ENCONTRADO);
        }
    }
}
