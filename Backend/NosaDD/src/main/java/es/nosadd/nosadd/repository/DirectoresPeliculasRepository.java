package es.nosadd.nosadd.repository;

import es.nosadd.nosadd.model.DirectoresPeliculas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DirectoresPeliculasRepository extends JpaRepository<DirectoresPeliculas, Integer> {

    List<DirectoresPeliculas> findAllByDirectorId(int directorId);
    List<DirectoresPeliculas> findAllByPeliculaId(int peliculaId);
}
