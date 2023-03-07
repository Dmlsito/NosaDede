package es.nosadd.nosadd.controller;

import es.nosadd.nosadd.dto.ErrorDTO;
import es.nosadd.nosadd.dto.UsuarioDTO;
import es.nosadd.nosadd.model.Usuario;
import es.nosadd.nosadd.service.UsuarioService;
import es.nosadd.nosadd.util.Errores;
import es.nosadd.nosadd.util.Exitos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/Usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;


    @PostMapping("/Register")
    //@Operation(summary = "Insertar un Usuario")
    public ResponseEntity<?> guardarUsuario(@RequestBody UsuarioDTO usuarioDTO) {

        // Primero compruebo si ya existe este Correo Electrónico registrado //
        Optional<Usuario> usuarioConsultandoCorreo = usuarioService.consultarCorreo(usuarioDTO.getCorreoElectronico());

        // Segundo compruebo si ya existe este Nombre de Usuario registrado //
        Usuario usuarioConsultandoNombreUser = usuarioService.consultarNombreUser(usuarioDTO.getNombre_Usuario());

        // Si no existe ni el correo ni el nombre de usuario lo inserto //
        if (!usuarioConsultandoCorreo.isPresent()) {

            Usuario usuarioGuardado = usuarioService.save(usuarioDTO.fromDTO());
            return ResponseEntity.status(HttpStatus.CREATED).body(usuarioGuardado);

        } else {
            ErrorDTO errorDTO = new ErrorDTO(Errores.COD_ERROR_DUPLICADO,Errores.MEN_ERROR_DUPLICADO);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDTO);
        }

    }

    @GetMapping("/contrasena")
    //@Operation(summary = "Retorna la Contrasena para matchearla con la introducida en el login")

    public ResponseEntity<?> comprobarContrasena(@RequestBody UsuarioDTO usuarioDTO) {

        Usuario usuarioConsultado = usuarioService.consultarNombreUser(usuarioDTO.getNombre_Usuario());
        if(usuarioConsultado!=null){
            return ResponseEntity.status(HttpStatus.OK).body(usuarioConsultado.getContrasena());
        }else {
            ErrorDTO errorDTO = new ErrorDTO(Errores.COD_ERROR_DUPLICADO,Errores.MEN_ERROR_DUPLICADO);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDTO);
        }
    }

    @GetMapping("/usuario/nombre/{nombreUser}")
    //@Operation(summary = "Retorna la Contrasena para matchearla con la introducida en el login")

    public ResponseEntity<?> comprobarContrasena(@PathVariable String nombreUser) {

        Usuario usuarioConsultado = usuarioService.consultarNombreUser(nombreUser);
        if(usuarioConsultado!=null){
            return ResponseEntity.status(HttpStatus.OK).body(usuarioConsultado);
        }else {
            ErrorDTO errorDTO = new ErrorDTO(Errores.COD_ERROR_DUPLICADO,Errores.MEN_ERROR_DUPLICADO);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDTO);
        }

    }

    @DeleteMapping("/usuario/nombre/borrar/{nombreUser}")
    //@Operation(summary = "Eliminar Usuario")
    public ResponseEntity<?> borrarUsuario(@PathVariable String nombreUser) {


        if(nombreUser!=null){
            usuarioService.deleteByNombreUsuario(nombreUser);
            return ResponseEntity.status(HttpStatus.OK).body(Exitos.USUARIO_ELIMINADO);
        }else {
            ErrorDTO errorDTO = new ErrorDTO(Errores.COD_ERROR_DUPLICADO,Errores.MEN_ERROR_DUPLICADO);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDTO);
        }

    }
    // Actualizar usuario
    @PutMapping("/actualizar/{nombreUser}")
    //@Operation(summary = "Actualizar Nombre Usuario")
    public ResponseEntity<?> actualizarUsuario(@PathVariable String nombreUser,@RequestBody UsuarioDTO usuarioDTO) {

        Usuario usuarioConsultado = usuarioService.consultarNombreUser(nombreUser);

        if(usuarioConsultado!=null){
            usuarioConsultado.setNombre(usuarioDTO.getNombre());
            usuarioConsultado.setApellidos(usuarioDTO.getApellidos());
            usuarioConsultado.setNombreUsuario(usuarioDTO.getNombre_Usuario());
            usuarioConsultado.setImagenUsuario(usuarioDTO.getImagenUsuario());
            usuarioConsultado.setCorreoElectronico(usuarioDTO.getCorreoElectronico());
            usuarioConsultado.setContrasena(usuarioDTO.getContrasena());
            usuarioService.save(usuarioConsultado);
            return ResponseEntity.status(HttpStatus.OK).body(usuarioConsultado);

        }else {
            ErrorDTO errorDTO = new ErrorDTO(Errores.COD_ERROR_DUPLICADO,Errores.MEN_ERROR_DUPLICADO);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDTO);
        }
    }


}
