package es.nosadd.nosadd.service;

import es.nosadd.nosadd.model.ActoresPeliculas;
import es.nosadd.nosadd.repository.ActoresPeliculasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ActoresPeliculasServiceImp implements ActoresPeliculasService{

    @Autowired
    private ActoresPeliculasRepository actoresPeliculasRepository;

    @Override
    @Transactional(readOnly = true)
    public List<ActoresPeliculas> findAll() {
        return actoresPeliculasRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public ActoresPeliculas findById(int id) {
        return actoresPeliculasRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ActoresPeliculas> findAllByActorId(int actorId) {
        return actoresPeliculasRepository.findAllByActorId(actorId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ActoresPeliculas> findAllByPeliculaId(int peliculaId) {
        return actoresPeliculasRepository.findAllByPeliculaId(peliculaId);
    }

    @Override
    @Transactional
    public ActoresPeliculas save(ActoresPeliculas actoresPeliculas) {
        return actoresPeliculasRepository.save(actoresPeliculas);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        actoresPeliculasRepository.deleteById(id);
    }

}
