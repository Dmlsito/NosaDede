package es.nosadd.nosadd.service;

import es.nosadd.nosadd.model.DirectoresPeliculas;
import es.nosadd.nosadd.repository.DirectoresPeliculasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DirectoresPeliculasServiceImp implements DirectoresPeliculasService{

    @Autowired
    private DirectoresPeliculasRepository directoresPeliculasRepository;

    @Override
    @Transactional(readOnly = true)
    public List<DirectoresPeliculas> findAll() {
        return directoresPeliculasRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public DirectoresPeliculas findById(int id) {
        return directoresPeliculasRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DirectoresPeliculas> findAllByDirectorId(int directorId) {
        return directoresPeliculasRepository.findAllByDirectorId(directorId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DirectoresPeliculas> findAllByPeliculaId(int peliculaId) {
        return directoresPeliculasRepository.findAllByPeliculaId(peliculaId);
    }

    @Override
    @Transactional
    public DirectoresPeliculas save(DirectoresPeliculas directoresPeliculas) {
        return directoresPeliculasRepository.save(directoresPeliculas);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        directoresPeliculasRepository.deleteById(id);
    }


}
