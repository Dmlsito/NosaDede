package es.nosadd.nosadd.controller;

import es.nosadd.nosadd.dto.DirectorDTO;
import es.nosadd.nosadd.model.Director;
import es.nosadd.nosadd.service.DirectorService;
import es.nosadd.nosadd.util.Errores;
import es.nosadd.nosadd.util.Exitos;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
            directorService.save(directorDTO.toDirector());
            return ResponseEntity.status(HttpStatus.CREATED).body(Exitos.DIRECTOR_CREADO);
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

    @GetMapping("/all/nombre/{nombre}")
    public ResponseEntity<?> getDirectorByNombre(@PathVariable String nombre) {
        List<Director> directores = directorService.findAllByNombre(nombre);
        if (directores != null && !directores.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(directores);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_DIRECTORES_NO_ENCONTRADOS);
        }
    }

    @GetMapping("/all/apellido/{apellido}")
    public ResponseEntity<?> getDirectorByApellido(@PathVariable String apellidos) {
        List<Director> directores = directorService.findAllByApellidos(apellidos);
        if (directores != null && !directores.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(directores);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_DIRECTORES_NO_ENCONTRADOS);
        }
    }

    @GetMapping("/all/nombre/{nombre}/apellido/{apellido}")
    public ResponseEntity<?> getDirectorByNombreAndApellido(@PathVariable String nombre, @PathVariable String apellidos) {
        List<Director> directores = directorService.findAllByNombreAndApellidos(nombre, apellidos);
        if (directores != null && !directores.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(directores);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_DIRECTORES_NO_ENCONTRADOS);
        }
    }

    @GetMapping("/all/nacionalidad/{nacionalidad}")
    public ResponseEntity<?> getDirectorByNacionalidad(@PathVariable String nacionalidad) {
        List<Director> directores = directorService.findAllByNacionalidad(nacionalidad);
        if (directores != null && !directores.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(directores);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_DIRECTORES_NO_ENCONTRADOS);
        }
    }

    @GetMapping("/all/fechaNacimiento/{fechaNacimiento}")
    public ResponseEntity<?> getDirectorByFechaNacimiento(@PathVariable String fechaNacimiento) {
        List<Director> directores = directorService.findAllByFechaNacimiento(fechaNacimiento);
        if (directores != null && !directores.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(directores);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_DIRECTORES_NO_ENCONTRADOS);
        }
    }

    @GetMapping("/all/valoracion/{valoracion}")
    public ResponseEntity<?> getDirectorByValoracion(@PathVariable int valoracion) {
        List<Director> directores = directorService.findAllByValoracion(valoracion);
        if (directores != null && !directores.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(directores);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_DIRECTORES_NO_ENCONTRADOS);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllDirectores() {
        if (directorService.findAll().size() > 0) {
            return ResponseEntity.status(HttpStatus.OK).body(directorService.findAll());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_DIRECTORES_NO_ENCONTRADOS);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteDirector(@PathVariable int id) {
        Director director = directorService.findById(id);
        if (director != null) {
            directorService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(Exitos.DIRECTOR_ELIMINADO);
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
            director.setNacionalidad(directorDTO.getNacionalidad());
            director.setValoracion(directorDTO.getValoracion());
            director.setHistoria(directorDTO.getHistoria());
            director.setImagenDirector(directorDTO.getImagenDirector());
            directorService.save(director);
            return ResponseEntity.status(HttpStatus.OK).body(Exitos.DIRECTOR_EDITADO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_DIRECTOR_NO_ENCONTRADO);
        }
    }

    @GetMapping("/all/valoracion/mayor/{valoracion}")
    public ResponseEntity<?> getDirectorByValoracionMayor(@PathVariable int valoracion) {
        List<Director> directores = directorService.findByValoracionGreaterThan(valoracion);
        if (directores != null && !directores.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(directores);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_DIRECTORES_NO_ENCONTRADOS);
        }
    }

    @GetMapping("/all/valoracion/menor/{valoracion}")
    public ResponseEntity<?> getDirectorByValoracionMenor(@PathVariable int valoracion) {
        List<Director> directores = directorService.findByValoracionLessThan(valoracion);
        if (directores != null && !directores.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(directores);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_DIRECTORES_NO_ENCONTRADOS);
        }
    }


}
