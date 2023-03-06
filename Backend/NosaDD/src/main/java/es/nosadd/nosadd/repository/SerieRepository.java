package es.nosadd.nosadd.repository;

import es.nosadd.nosadd.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SerieRepository extends JpaRepository<Serie, Integer> {

    List<Serie> findAllByTitulo(String titulo);
    List<Serie> findAllByTemporadas(int temporadas);
    List<Serie> findAllByTemporadasGreaterThan(int temporadas);
    List<Serie> findAllByTemporadasLessThan(int temporadas);
    List<Serie> findAllByValoracion(int valoracion);
    List<Serie> findAllByValoracionGreaterThan(int valoracion);
    List<Serie> findAllByValoracionLessThan(int valoracion);
    List<Serie> findAllByCapitulos(int capitulos);
    List<Serie> findAllByCapitulosGreaterThan(int capitulos);
    List<Serie> findAllByCapitulosLessThan(int capitulos);
}
