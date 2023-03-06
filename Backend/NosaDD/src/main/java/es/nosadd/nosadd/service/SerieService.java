package es.nosadd.nosadd.service;

import es.nosadd.nosadd.model.Serie;

import java.util.List;

public interface SerieService {

    List<Serie> findAll();
    Serie findById(int id);
    List<Serie> findAllByTitulo(String Titulo);
    List<Serie> findAllByTemporadas(int temporadas);
    List<Serie> findAllByTemporadasGreaterThan(int temporadas);
    List<Serie> findAllByTemporadasLessThan(int temporadas);
    List<Serie> findAllByValoracion(int valoracion);
    List<Serie> findAllByValoracionGreaterThan(int valoracion);
    List<Serie> findAllByValoracionLessThan(int valoracion);
    List<Serie> findAllByCapitulos(int capitulos);
    List<Serie> findAllByCapitulosGreaterThan(int capitulos);
    List<Serie> findAllByCapitulosLessThan(int capitulos);
    Serie save(Serie serie);
    void deleteById(int id);
}
