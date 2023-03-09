package es.nosadd.nosadd.repository;

import es.nosadd.nosadd.model.GenerosSeries;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GenerosSeriesRepository extends JpaRepository<GenerosSeries, Integer> {

    List<GenerosSeries> findAllByGeneroId(int generoId);

    List<GenerosSeries> findAllBySerieId(int serieId);

}
