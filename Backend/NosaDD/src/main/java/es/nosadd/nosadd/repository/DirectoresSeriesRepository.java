package es.nosadd.nosadd.repository;

import es.nosadd.nosadd.model.DirectoresSeries;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DirectoresSeriesRepository extends JpaRepository<DirectoresSeries, Integer> {

    List<DirectoresSeries> findAllByDirectorId(int directorId);

    List<DirectoresSeries> findAllBySerieId(int serieId);
}
