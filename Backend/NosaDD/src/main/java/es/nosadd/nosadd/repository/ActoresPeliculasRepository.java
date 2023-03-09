package es.nosadd.nosadd.repository;

import es.nosadd.nosadd.model.ActoresPeliculas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActoresPeliculasRepository extends JpaRepository<ActoresPeliculas, Integer> {

    List<ActoresPeliculas> findAllByActorId(int actorId);
    List<ActoresPeliculas> findAllByPeliculaId(int peliculaId);
}
