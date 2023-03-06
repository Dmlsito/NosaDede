package es.nosadd.nosadd.service;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.nosadd.nosadd.model.Genero;
import es.nosadd.nosadd.repository.GeneroRepository;

import java.util.List;

@Service
public class GeneroServiceImp implements GeneroService{

    @Autowired
    private GeneroRepository generoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Genero> findAll() {
        return generoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Genero findById(int id) {
        return generoRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Genero findByNombre(String nombre) {
        return generoRepository.findByNombre(nombre);
    }

    @Override
    @Transactional
    public Genero save(Genero genero) {
        return generoRepository.save(genero);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        generoRepository.deleteById(id);
    }

}
