package es.nosadd.nosadd.service;

import es.nosadd.nosadd.model.DirectoresPeliculas;

import java.util.List;

public interface DirectoresPeliculasService {

    List<DirectoresPeliculas> findAll();
    DirectoresPeliculas findById(int id);
    List<DirectoresPeliculas> findAllByDirectorId(int directorId);
    List<DirectoresPeliculas> findAllByPeliculaId(int peliculaId);
    DirectoresPeliculas save(DirectoresPeliculas directoresPeliculas);
    void deleteById(int id);
}
