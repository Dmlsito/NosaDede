package es.nosadd.nosadd.repository;

import es.nosadd.nosadd.model.Usuario;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

// Clase donde creo el contrato que han de cumplir las clases que implementen esta interfaz //

@Repository
public interface UsuarioRepository extends JpaRepositoryImplementation<Usuario,Integer> {

    // Método para encontrar usuarios que contengan un nombre//
    List<Usuario> findByNombreContains(String nombre);

    // Método para encontrar usuarios que su nombre sea exactamente igual al guardado en la base de datos //
    Optional<Usuario> findByNombre(String nombre);

    // Método para comprobar que la contraseña del usuario sea correcta //
    Optional<Usuario> findByContrasena(String contrasena);


}
