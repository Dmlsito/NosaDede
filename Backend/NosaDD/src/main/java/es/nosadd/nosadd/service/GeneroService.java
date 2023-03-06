package es.nosadd.nosadd.service;

import es.nosadd.nosadd.model.Genero;

import java.util.List;

public interface GeneroService {

    List<Genero> findAll();
    Genero findById(int id);
    Genero findByNombre(String nombre);
    Genero save(Genero genero);
    void deleteById(int id);
}
