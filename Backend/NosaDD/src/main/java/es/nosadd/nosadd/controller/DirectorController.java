package es.nosadd.nosadd.controller;

import es.nosadd.nosadd.dto.DirectorDTO;
import es.nosadd.nosadd.model.Director;
import es.nosadd.nosadd.service.DirectorService;
import es.nosadd.nosadd.util.Errores;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/director")
@Tag(name = "Director", description = "API de director")
public class DirectorController {

    @Autowired
    private DirectorService directorService;

    @PostMapping
    @Operation(summary = "Insertar un director")
    public ResponseEntity<?> insertarDirector(@RequestBody DirectorDTO directorDTO) {

        Director directorConsultado = directorService.findById(directorDTO.toDirector().getId());

        if (directorConsultado == null) {
            Director directorGuardado = directorService.save(directorDTO.toDirector());
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Errores.ERROR_DIRECTOR_YA_EXISTE);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDirector(@PathVariable int id) {
        Director director = directorService.findById(id);
        if (director != null) {
            return ResponseEntity.status(HttpStatus.OK).body(director);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_DIRECTOR_NO_ENCONTRADO);
        }
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<?> getDirector(@PathVariable String nombre) {
        Optional<Director> director = directorService.findByNombre(nombre);
        if (director.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(director);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_DIRECTOR_NO_ENCONTRADO);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllDirectores() {
        return ResponseEntity.status(HttpStatus.OK).body(directorService.findAll());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteDirector(@PathVariable int id) {
        Director director = directorService.findById(id);
        if (director != null) {
            directorService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(Errores.DIRECTOR_ELIMINADO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_DIRECTOR_NO_ENCONTRADO);
        }
    }

    @DeleteMapping("/delete/nombre/{nombre}")
    public ResponseEntity<?> deleteDirector(@PathVariable String nombre) {
        Optional<Director> director = directorService.findByNombre(nombre);
        if (director.isPresent()) {
            directorService.deleteById(director.get().getId());
            return ResponseEntity.status(HttpStatus.OK).body(Errores.DIRECTOR_ELIMINADO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_DIRECTOR_NO_ENCONTRADO);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateDirector(@PathVariable int id, @RequestBody DirectorDTO directorDTO) {
        Director director = directorService.findById(id);
        if (director != null) {
            director.setNombre(directorDTO.getNombre());
            director.setApellidos(directorDTO.getApellidos());
            director.setFechaNacimiento(directorDTO.getFechaNacimiento());
            directorService.save(director);
            return ResponseEntity.status(HttpStatus.OK).body(director);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_DIRECTOR_NO_ENCONTRADO);
        }
    }

}
