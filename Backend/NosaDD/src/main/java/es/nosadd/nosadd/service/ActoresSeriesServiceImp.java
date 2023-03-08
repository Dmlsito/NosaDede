package es.nosadd.nosadd.service;

import es.nosadd.nosadd.repository.ActoresSeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import es.nosadd.nosadd.model.ActoresSeries;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ActoresSeriesServiceImp implements ActoresSeriesService{

    @Autowired
    private ActoresSeriesRepository actoresSeriesRepository;

    @Override
    @Transactional(readOnly = true)
    public java.util.List<ActoresSeries> findAll() {
        return actoresSeriesRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public ActoresSeries findById(int id) {
        return actoresSeriesRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public java.util.List<ActoresSeries> findAllByActorId(int actorId) {
        return actoresSeriesRepository.findAllByActorId(actorId);
    }

    @Override
    @Transactional(readOnly = true)
    public java.util.List<ActoresSeries> findAllBySerieId(int serieId) {
        return actoresSeriesRepository.findAllBySerieId(serieId);
    }

    @Override
    @Transactional
    public ActoresSeries save(ActoresSeries actoresSeries) {
        return actoresSeriesRepository.save(actoresSeries);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        actoresSeriesRepository.deleteById(id);
    }

}
