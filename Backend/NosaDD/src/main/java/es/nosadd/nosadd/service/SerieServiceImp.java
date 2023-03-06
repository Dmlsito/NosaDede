package es.nosadd.nosadd.service;

import es.nosadd.nosadd.model.Serie;
import es.nosadd.nosadd.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SerieServiceImp implements SerieService {

    @Autowired
    private SerieRepository serieRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Serie> findAll() {
        return serieRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Serie findById(int id) {
        return serieRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Serie> findAllByTitulo(String titulo) {
        return serieRepository.findAllByTitulo(titulo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Serie> findAllByTemporadas(int temporadas) {
        return serieRepository.findAllByTemporadas(temporadas);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Serie> findAllByTemporadasGreaterThan(int temporadas) {
        return serieRepository.findAllByTemporadasGreaterThan(temporadas);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Serie> findAllByTemporadasLessThan(int temporadas) {
        return serieRepository.findAllByTemporadasLessThan(temporadas);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Serie> findAllByValoracion(int valoracion) {
        return serieRepository.findAllByValoracion(valoracion);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Serie> findAllByValoracionGreaterThan(int valoracion) {
        return serieRepository.findAllByValoracionGreaterThan(valoracion);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Serie> findAllByValoracionLessThan(int valoracion) {
        return serieRepository.findAllByValoracionLessThan(valoracion);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Serie> findAllByCapitulos(int capitulos) {
        return serieRepository.findAllByCapitulos(capitulos);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Serie> findAllByCapitulosGreaterThan(int capitulos) {
        return serieRepository.findAllByCapitulosGreaterThan(capitulos);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Serie> findAllByCapitulosLessThan(int capitulos) {
        return serieRepository.findAllByCapitulosLessThan(capitulos);
    }

    @Override
    @Transactional
    public Serie save(Serie serie) {
        return serieRepository.save(serie);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        serieRepository.deleteById(id);
    }

}
