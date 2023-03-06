package es.nosadd.nosadd.service;

import es.nosadd.nosadd.model.Actor;

import java.util.List;

public interface ActorService {

    List<Actor> findAll();
    Actor findById(int id);
    List<Actor> findAllByNombre(String nombre);
    List<Actor> findAllByApellidos(String apellidos);
    List<Actor> findAllByNombreAndApellidos(String nombre, String apellidos);
    List<Actor> findAllByNacionalidad(String nacionalidad);
    List<Actor> findAllByFechaNacimiento(String fechaNacimiento);
    List<Actor> findAllByValoracion(int valoracion);
    List<Actor> findByValoracionGreaterThan(int valoracion);
    List<Actor> findByValoracionLessThan(int valoracion);
    Actor save(Actor actor);
    void deleteById(int id);
}
