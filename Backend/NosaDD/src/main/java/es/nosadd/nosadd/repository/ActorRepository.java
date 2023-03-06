package es.nosadd.nosadd.repository;

import es.nosadd.nosadd.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActorRepository extends JpaRepository<Actor, Integer> {

    List<Actor> findAllByNombre(String nombre);
    List<Actor> findAllByApellidos(String apellidos);
    List<Actor> findAllByNombreAndApellidos(String nombre, String apellidos);
    List<Actor> findAllByNacionalidad(String nacionalidad);
    List<Actor> findAllByFechaNacimiento(String fechaNacimiento);
    List<Actor> findAllByValoracion(int valoracion);
    List<Actor> findByValoracionGreaterThan(int valoracion);
    List<Actor> findByValoracionLessThan(int valoracion);
}
