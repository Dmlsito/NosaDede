package es.nosadd.nosadd.repository;

import es.nosadd.nosadd.model.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PeliculaRepository extends JpaRepository<Pelicula, Integer> {

    List<Pelicula> findAllByTitulo(String titulo);
    List<Pelicula> findAllByValoracion(int valoracion);
    List<Pelicula> findAllByValoracionGreaterThan(int valoracion);
    List<Pelicula> findAllByValoracionLessThan(int valoracion);

}
