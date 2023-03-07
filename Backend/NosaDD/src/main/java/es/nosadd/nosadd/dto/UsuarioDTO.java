package es.nosadd.nosadd.dto;

import es.nosadd.nosadd.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class UsuarioDTO {

    private int id;
    private String nombre;
    private String apellidos;
    private String nombreUsuario;
    private String imagenUsuario;
    private String correoElectronico;
    private String contrasena;

    // Método para transformar un usuario en un usuarioDTO //
    public UsuarioDTO toDTO (Usuario usuario){

        this.setId(usuario.getId());
        this.setNombre(usuario.getNombre());
        this.setApellidos(usuario.getApellidos());
        this.setNombreUsuario(usuario.getNombreUsuario());
        this.setImagenUsuario(usuario.getImagenUsuario());
        this.setCorreoElectronico(usuario.getCorreoElectronico());
        this.setContrasena(usuario.getContrasena());
        return this;

    }
    // Método para transformar de usuarioDTO a usuario //
    public Usuario fromDTO(){
        Usuario usuario = new Usuario();
        usuario.setId(this.id);
        usuario.setNombre(this.nombre);
        usuario.setApellidos(this.apellidos);
        usuario.setImagenUsuario(this.imagenUsuario);
        usuario.setNombreUsuario(this.nombreUsuario);
        usuario.setCorreoElectronico(this.correoElectronico);
        usuario.setContrasena(this.contrasena);

        return usuario;

    }

}
