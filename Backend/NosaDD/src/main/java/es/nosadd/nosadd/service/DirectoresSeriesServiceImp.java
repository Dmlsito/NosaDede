package es.nosadd.nosadd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import es.nosadd.nosadd.model.DirectoresSeries;
import es.nosadd.nosadd.repository.DirectoresSeriesRepository;

import java.util.List;

@Service
public class DirectoresSeriesServiceImp implements DirectoresSeriesService{

    @Autowired
    private DirectoresSeriesRepository directoresSeriesRepository;

    @Override
    @Transactional(readOnly = true)
    public List<DirectoresSeries> findAll() {
        return directoresSeriesRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public DirectoresSeries findById(int id) {
        return directoresSeriesRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DirectoresSeries> findAllByDirectorId(int directorId) {
        return directoresSeriesRepository.findAllByDirectorId(directorId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DirectoresSeries> findAllBySerieId(int serieId) {
        return directoresSeriesRepository.findAllBySerieId(serieId);
    }

    @Override
    @Transactional
    public DirectoresSeries save(DirectoresSeries directoresSeries) {
        return directoresSeriesRepository.save(directoresSeries);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        directoresSeriesRepository.deleteById(id);
    }


}
