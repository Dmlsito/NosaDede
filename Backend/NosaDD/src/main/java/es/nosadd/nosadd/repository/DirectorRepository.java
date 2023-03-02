package es.nosadd.nosadd.repository;

import es.nosadd.nosadd.model.Director;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DirectorRepository extends JpaRepository<Director, Integer> {

    List<Director> findAllByNombre(String nombre);
    List<Director> findAllByApellidos(String apellidos);
    List<Director> findAllByNombreAndApellidos(String nombre, String apellidos);
    List<Director> findAllByNacionalidad(String nacionalidad);
    List<Director> findAllByFechaNacimiento(String fechaNacimiento);
    List<Director> findAllByValoracion(int valoracion);

}
