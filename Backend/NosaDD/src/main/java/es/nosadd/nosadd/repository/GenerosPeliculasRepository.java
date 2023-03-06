package es.nosadd.nosadd.repository;

import es.nosadd.nosadd.model.GenerosPeliculas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GenerosPeliculasRepository extends JpaRepository<GenerosPeliculas, Integer> {

    List<GenerosPeliculas> findAllByGeneroId(int generoId);
    List<GenerosPeliculas> findAllByPeliculaId(int peliculaId);
}
