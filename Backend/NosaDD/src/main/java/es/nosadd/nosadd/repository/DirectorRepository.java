package es.nosadd.nosadd.repository;

import es.nosadd.nosadd.model.Director;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DirectorRepository extends JpaRepository<Director, Integer> {

    Optional<Director> findByNombre(String nombre);
    List<Director> findAllByOrderByNombreAsc();

}
