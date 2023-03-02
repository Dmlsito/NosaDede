package es.nosadd.nosadd.service;

import es.nosadd.nosadd.model.Usuario;
import es.nosadd.nosadd.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImp  implements UsuarioService{

    // Inyección de depencias: Ventaja: Con esto necesito crear objetos de forma explicita
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<Usuario> consultar(String nombre) {
        return Optional.empty();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Usuario> consultarNombreUser(String nombreUser) {
        return Optional.empty();
    }

    @Override
    @Transactional
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    @Transactional
    public void borrar(String nombre, String contrasena) {
    }

    // DE MOMENTO ESTÁ NO ESTA IMPLEMENTADA //
    @Override
    @Transactional(readOnly = true)
    public List<Usuario> buscarTodo() {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Usuario> consultarCorreo(String correo) {
        return Optional.empty();
    }
}
