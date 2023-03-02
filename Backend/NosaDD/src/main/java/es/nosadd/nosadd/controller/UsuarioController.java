package es.nosadd.nosadd.controller;

import es.nosadd.nosadd.dto.ErrorDTO;
import es.nosadd.nosadd.dto.UsuarioDTO;
import es.nosadd.nosadd.model.Usuario;
import es.nosadd.nosadd.service.UsuarioService;
import es.nosadd.nosadd.util.Errores;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/Usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;


    @PostMapping
    @Operation(summary = "Insertar un Usuario")
    @RequestMapping("/api/Usuarios/Register")
    public ResponseEntity<?> guardarUsuario(@RequestBody UsuarioDTO usuarioDTO) {

        // Primero compruebo si ya existe este Correo Electrónico registrado //
        Optional<Usuario> usuarioConsultandoCorreo = usuarioService.consultarCorreo(usuarioDTO.getCorreoElectronico());

        // Segundo compruebo si ya existe este Nombre de Usuario registrado //
        Optional<Usuario> usuarioConsultandoNombreUser = usuarioService.consultarNombreUser(usuarioDTO.getNombreUsuario());

        // Si no existe ni el correo ni el nombre de usuario lo inserto //
        if (!usuarioConsultandoCorreo.isPresent() && !usuarioConsultandoNombreUser.isPresent()) {

            Usuario usuarioGuardado = usuarioService.save(usuarioDTO.fromDTO());
            return ResponseEntity.status(HttpStatus.CREATED).body(usuarioGuardado);

        } else {
            ErrorDTO errorDTO = new ErrorDTO(Errores.COD_ERROR_DUPLICADO,Errores.MEN_ERROR_DUPLICADO);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }


    }
}
