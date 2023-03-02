package es.nosadd.nosadd.service;


import es.nosadd.nosadd.model.Usuario;

import java.util.List;
import java.util.Optional;

// Clase que contiene los métodos de las clases service //
public interface UsuarioService {

    // Método para buscar si existe un usuario con un nombre //
    public Optional<Usuario> consultar(String nombre);

    // Método para buscar si existe un nombre de usuario //
    public Optional<Usuario> consultarNombreUser (String nombreUser);

    //Método para guardar el usuario en la bbdd //
     public Usuario save(Usuario usuario);

    // Método donde mando un usuario y su contraseña para validar su eliminacion de la bbdd //
    public void borrar(String nombre, String contrasena);

    //Método para recoger una lista de usuarios //
    public List<Usuario> buscarTodo();

    // Método para comprobar si existe ya el correo registrado //
    public Optional<Usuario> consultarCorreo(String correo);

}
