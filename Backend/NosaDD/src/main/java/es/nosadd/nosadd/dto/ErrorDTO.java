package es.nosadd.nosadd.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Clase para mostrar errores al usuario //

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ErrorDTO {

    private String error;
    private String mensaje;
}

