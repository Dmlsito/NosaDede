package es.nosadd.nosadd.repository;

import es.nosadd.nosadd.model.ActoresSeries;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActoresSeriesRepository extends JpaRepository<ActoresSeries, Integer> {

    List<ActoresSeries> findAllByActorId(int actorId);
    List<ActoresSeries> findAllBySerieId(int serieId);
}
