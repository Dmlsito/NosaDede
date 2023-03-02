package es.nosadd.nosadd.service;

import es.nosadd.nosadd.model.Director;

import java.util.List;
import java.util.Optional;

public interface DirectorService {

    List<Director> findAll();
    Director findById(int id);
    Optional<Director> findByNombre(String nombre);
    Director save(Director director);
    void deleteById(int id);
}
