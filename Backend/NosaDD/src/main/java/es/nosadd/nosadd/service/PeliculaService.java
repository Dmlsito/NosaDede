package es.nosadd.nosadd.service;

import es.nosadd.nosadd.model.Pelicula;

import java.util.List;

public interface PeliculaService {

    List<Pelicula> findAll();
    Pelicula findById(int id);
    List<Pelicula> findAllByTitulo(String titulo);
    List<Pelicula> findAllByValoracion(int valoracion);
    List<Pelicula> findAllByValoracionGreaterThan(int valoracion);
    List<Pelicula> findAllByValoracionLessThan(int valoracion);
    Pelicula save(Pelicula pelicula);
    void deleteById(int id);
}
