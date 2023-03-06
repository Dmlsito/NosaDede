package es.nosadd.nosadd.controller;

import es.nosadd.nosadd.dto.ActorDTO;
import es.nosadd.nosadd.model.Actor;
import es.nosadd.nosadd.service.ActorService;
import es.nosadd.nosadd.util.Errores;
import es.nosadd.nosadd.util.Exitos;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/actor")
@Tag(name = "Actor", description = "API de actor")
public class ActorController {

    @Autowired
    private ActorService actorService;

    @PostMapping
    public ResponseEntity<?> insertarActor(@RequestBody ActorDTO actorDTO) {

        Actor actorConsultado = actorService.findById(actorDTO.toActor().getId());

        if (actorConsultado == null) {
            actorService.save(actorDTO.toActor());
            return ResponseEntity.status(HttpStatus.CREATED).body(Exitos.ACTOR_CREADO);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Errores.ERROR_ACTOR_YA_EXISTE);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getActor(@PathVariable int id) {
        Actor actor = actorService.findById(id);
        if (actor != null) {
            return ResponseEntity.status(HttpStatus.OK).body(actor);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_ACTOR_NO_ENCONTRADO);
        }
    }

    @GetMapping("/all/nombre/{nombre}")
    public ResponseEntity<?> getActorByNombre(@PathVariable String nombre) {
        List<Actor> actores = actorService.findAllByNombre(nombre);
        if (actores != null && !actores.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(actores);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_ACTORES_NO_ENCONTRADOS);
        }
    }

    @GetMapping("/all/apellido/{apellido}")
    public ResponseEntity<?> getActorByApellido(@PathVariable String apellido) {
        List<Actor> actores = actorService.findAllByApellidos(apellido);
        if (actores != null && !actores.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(actores);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_ACTORES_NO_ENCONTRADOS);
        }
    }

    @GetMapping("/all/nombre/{nombre}/apellido/{apellido}")
    public ResponseEntity<?> getActorByNombreAndApellido(@PathVariable String nombre, @PathVariable String apellido) {
        List<Actor> actores = actorService.findAllByNombreAndApellidos(nombre, apellido);
        if (actores != null && !actores.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(actores);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_ACTORES_NO_ENCONTRADOS);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllActores() {
        List<Actor> actores = actorService.findAll();
        if (actores != null && !actores.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(actores);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_ACTORES_NO_ENCONTRADOS);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateActor(@PathVariable int id, @RequestBody ActorDTO actorDTO) {
        Actor actor = actorService.findById(id);
        if (actor != null) {
            actor.setNombre(actorDTO.getNombre());
            actor.setApellidos(actorDTO.getApellidos());
            actor.setFechaNacimiento(actorDTO.getFechaNacimiento());
            actor.setNacionalidad(actorDTO.getNacionalidad());
            actor.setHistoria(actorDTO.getHistoria());
            actor.setImagenActor(actorDTO.getImagenActor());
            actor.setValoracion(actorDTO.getValoracion());
            actorService.save(actor);
            return ResponseEntity.status(HttpStatus.OK).body(Exitos.ACTOR_EDITADO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_ACTOR_NO_ENCONTRADO);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteActor(@PathVariable int id) {
        Actor actor = actorService.findById(id);
        if (actor != null) {
            actorService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(Exitos.ACTOR_ELIMINADO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_ACTOR_NO_ENCONTRADO);
        }
    }

    @GetMapping("/all/valoracion/{valoracion}")
    public ResponseEntity<?> getActorByValoracion(@PathVariable int valoracion) {
        List<Actor> actores = actorService.findAllByValoracion(valoracion);
        if (actores != null && !actores.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(actores);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_ACTORES_NO_ENCONTRADOS);
        }
    }

    @GetMapping("/all/valoracion/mayor/{valoracion}")
    public ResponseEntity<?> getActorByValoracionMayor(@PathVariable int valoracion) {
        List<Actor> actores = actorService.findByValoracionGreaterThan(valoracion);
        if (actores != null && !actores.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(actores);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_ACTORES_NO_ENCONTRADOS);
        }
    }

    @GetMapping("/all/valoracion/menor/{valoracion}")
    public ResponseEntity<?> getActorByValoracionMenor(@PathVariable int valoracion) {
        List<Actor> actores = actorService.findByValoracionLessThan(valoracion);
        if (actores != null && !actores.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(actores);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_ACTORES_NO_ENCONTRADOS);
        }
    }

    @GetMapping("/all/fechaNacimiento/{fechaNacimiento}")
    public ResponseEntity<?> getActorByFechaNacimiento(@PathVariable String fechaNacimiento) {
        List<Actor> actores = actorService.findAllByFechaNacimiento(fechaNacimiento);
        if (actores != null && !actores.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(actores);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_ACTORES_NO_ENCONTRADOS);
        }
    }

    @GetMapping("/all/Nacionalidad/{nacionalidad}")
    public ResponseEntity<?> getActorByNacionalidad(@PathVariable String nacionalidad) {
        List<Actor> actores = actorService.findAllByNacionalidad(nacionalidad);
        if (actores != null && !actores.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(actores);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Errores.ERROR_ACTORES_NO_ENCONTRADOS);
        }
    }

}
