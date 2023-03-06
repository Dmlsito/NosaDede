package es.nosadd.nosadd.service;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import es.nosadd.nosadd.model.Pelicula;
import es.nosadd.nosadd.repository.PeliculaRepository;

import java.util.List;

@Service
public class PeliculaServiceImp implements PeliculaService{

    @Autowired
    private PeliculaRepository peliculaRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Pelicula> findAll() {
        return peliculaRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Pelicula findById(int id) {
        return peliculaRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Pelicula> findAllByTitulo(String titulo) {
        return peliculaRepository.findAllByTitulo(titulo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Pelicula> findAllByValoracion(int valoracion) {
        return peliculaRepository.findAllByValoracion(valoracion);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Pelicula> findAllByValoracionGreaterThan(int valoracion) {
        return peliculaRepository.findAllByValoracionGreaterThan(valoracion);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Pelicula> findAllByValoracionLessThan(int valoracion) {
        return peliculaRepository.findAllByValoracionLessThan(valoracion);
    }

    @Override
    @Transactional
    public Pelicula save(Pelicula pelicula) {
        return peliculaRepository.save(pelicula);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        peliculaRepository.deleteById(id);
    }
}
