package es.nosadd.nosadd.service;

import es.nosadd.nosadd.model.ActoresPeliculas;

import java.util.List;

public interface ActoresPeliculasService {

    List<ActoresPeliculas> findAll();
    ActoresPeliculas findById(int id);
    List<ActoresPeliculas> findAllByActorId(int actorId);
    List<ActoresPeliculas> findAllByPeliculaId(int peliculaId);
    ActoresPeliculas save(ActoresPeliculas actoresPeliculas);
    void deleteById(int id);
}
