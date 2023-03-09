package es.nosadd.nosadd.service;

import es.nosadd.nosadd.model.GenerosSeries;

import java.util.List;

public interface GenerosSeriesService {

    List<GenerosSeries> findAll();
    GenerosSeries findById(int id);
    List<GenerosSeries> findAllByGeneroId(int generoId);
    List<GenerosSeries> findAllBySerieId(int serieId);
    GenerosSeries save(GenerosSeries generosSeries);
    void deleteById(int id);
}
