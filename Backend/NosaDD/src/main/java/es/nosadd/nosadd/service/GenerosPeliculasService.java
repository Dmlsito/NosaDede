package es.nosadd.nosadd.service;

import es.nosadd.nosadd.model.GenerosPeliculas;

import java.util.List;

public interface GenerosPeliculasService {

    List<GenerosPeliculas> findAll();
    GenerosPeliculas findById(int id);
    List<GenerosPeliculas> findAllByGeneroId(int generoId);
    List<GenerosPeliculas> findAllByPeliculaId(int peliculaId);
    GenerosPeliculas save(GenerosPeliculas generosPeliculas);
    void deleteById(int id);
}
