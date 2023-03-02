package es.nosadd.nosadd.service;

import es.nosadd.nosadd.model.Director;
import es.nosadd.nosadd.repository.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DirectorServiceImp implements DirectorService{

    @Autowired
    private DirectorRepository directorRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Director> findAll() {
        return directorRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Director findById(int id) {
        return directorRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Director> findByNombre(String nombre) {
        return directorRepository.findByNombre(nombre);
    }

    @Override
    @Transactional
    public Director save(Director director) {
        return directorRepository.save(director);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        directorRepository.deleteById(id);
    }


}
