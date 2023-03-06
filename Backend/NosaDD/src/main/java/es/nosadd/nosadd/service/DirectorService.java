package es.nosadd.nosadd.service;

import es.nosadd.nosadd.model.Director;

import java.util.List;
import java.util.Optional;

public interface DirectorService {

    List<Director> findAll();

    Director findById(int id);

    List<Director> findAllByNombre(String nombre);

    List<Director> findAllByApellidos(String apellidos);

    List<Director> findAllByNombreAndApellidos(String nombre, String apellidos);

    List<Director> findAllByNacionalidad(String nacionalidad);

    List<Director> findAllByFechaNacimiento(String fechaNacimiento);

    List<Director> findAllByValoracion(int valoracion);

    List<Director> findByValoracionGreaterThan(int valoracion);
    List<Director> findByValoracionLessThan(int valoracion);

    Director save(Director director);

    void deleteById(int id);
}
