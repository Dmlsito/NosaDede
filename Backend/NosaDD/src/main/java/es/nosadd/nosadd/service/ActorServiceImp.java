package es.nosadd.nosadd.service;

import es.nosadd.nosadd.model.Actor;
import es.nosadd.nosadd.repository.ActorRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImp implements ActorService {

    @Autowired
    private ActorRepository actorRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Actor> findAll() {
        return actorRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Actor findById(int id) {
        return actorRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Actor save(Actor actor) {
        return actorRepository.save(actor);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        actorRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Actor> findAllByNombre(String nombre) {
        return actorRepository.findAllByNombre(nombre);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Actor> findAllByApellidos(String apellidos) {
        return actorRepository.findAllByApellidos(apellidos);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Actor> findAllByNombreAndApellidos(String nombre, String apellidos) {
        return actorRepository.findAllByNombreAndApellidos(nombre, apellidos);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Actor> findAllByNacionalidad(String nacionalidad) {
        return actorRepository.findAllByNacionalidad(nacionalidad);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Actor> findAllByFechaNacimiento(String fechaNacimiento) {
        return actorRepository.findAllByFechaNacimiento(fechaNacimiento);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Actor> findAllByValoracion(int valoracion) {
        return actorRepository.findAllByValoracion(valoracion);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Actor> findByValoracionGreaterThan(int valoracion) {
        return actorRepository.findByValoracionGreaterThan(valoracion);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Actor> findByValoracionLessThan(int valoracion) {
        return actorRepository.findByValoracionLessThan(valoracion);
    }

}
