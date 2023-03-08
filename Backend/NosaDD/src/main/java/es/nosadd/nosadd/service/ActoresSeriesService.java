package es.nosadd.nosadd.service;

import es.nosadd.nosadd.model.ActoresSeries;

import java.util.List;

public interface ActoresSeriesService {

    List<ActoresSeries> findAll();
    ActoresSeries findById(int id);
    List<ActoresSeries> findAllByActorId(int actorId);
    List<ActoresSeries> findAllBySerieId(int serieId);
    ActoresSeries save(ActoresSeries actoresSeries);
    void deleteById(int id);
}
