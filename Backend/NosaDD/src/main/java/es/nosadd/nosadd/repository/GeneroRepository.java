package es.nosadd.nosadd.repository;

import es.nosadd.nosadd.model.Genero;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeneroRepository extends JpaRepository<Genero, Integer> {

    Genero findByNombre(String nombre);
}
