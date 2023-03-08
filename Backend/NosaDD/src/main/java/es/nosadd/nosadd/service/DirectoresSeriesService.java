package es.nosadd.nosadd.service;

import es.nosadd.nosadd.model.DirectoresSeries;

import java.util.List;

public interface DirectoresSeriesService {

    List<DirectoresSeries> findAll();
    DirectoresSeries findById(int id);
    List<DirectoresSeries> findAllByDirectorId(int directorId);
    List<DirectoresSeries> findAllBySerieId(int serieId);
    DirectoresSeries save(DirectoresSeries directoresSeries);
    void deleteById(int id);
}
