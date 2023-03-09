package es.nosadd.nosadd.service;

import es.nosadd.nosadd.repository.GenerosSeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import es.nosadd.nosadd.model.GenerosSeries;

import java.util.List;

@Service
public class GenerosSeriesServiceImp implements GenerosSeriesService{

    @Autowired
    private GenerosSeriesRepository generosSeriesRepository;

    @Override
    @Transactional(readOnly = true)
    public List<GenerosSeries> findAll() {
        return generosSeriesRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public GenerosSeries findById(int id) {
        return generosSeriesRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<GenerosSeries> findAllByGeneroId(int generoId) {
        return generosSeriesRepository.findAllByGeneroId(generoId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<GenerosSeries> findAllBySerieId(int serieId) {
        return generosSeriesRepository.findAllBySerieId(serieId);
    }

    @Override
    @Transactional
    public GenerosSeries save(GenerosSeries generosSeries) {
        return generosSeriesRepository.save(generosSeries);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        generosSeriesRepository.deleteById(id);
    }
}
