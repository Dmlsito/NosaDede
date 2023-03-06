package es.nosadd.nosadd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import es.nosadd.nosadd.model.GenerosPeliculas;
import es.nosadd.nosadd.repository.GenerosPeliculasRepository;

import java.util.List;

@Service
public class GenerosPeliculasServiceImp implements GenerosPeliculasService{

    @Autowired
    private GenerosPeliculasRepository generosPeliculasRepository;

    @Override
    @Transactional(readOnly = true)
    public List<GenerosPeliculas> findAll() {
        return generosPeliculasRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public GenerosPeliculas findById(int id) {
        return generosPeliculasRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<GenerosPeliculas> findAllByGeneroId(int generoId) {
        return generosPeliculasRepository.findAllByGeneroId(generoId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<GenerosPeliculas> findAllByPeliculaId(int peliculaId) {
        return generosPeliculasRepository.findAllByPeliculaId(peliculaId);
    }

    @Override
    @Transactional
    public GenerosPeliculas save(GenerosPeliculas generosPeliculas) {
        return generosPeliculasRepository.save(generosPeliculas);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        generosPeliculasRepository.deleteById(id);
    }
}
