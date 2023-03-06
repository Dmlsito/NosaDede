package es.nosadd.nosadd.dto;

import es.nosadd.nosadd.model.Genero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeneroDTO {

    private int id;
    private String nombre;

    public GeneroDTO(String nombre) {
        this.nombre = nombre;
    }

    public GeneroDTO fromGenero(Genero genero) {
        return new GeneroDTO(genero.getId(), genero.getNombre());
    }

    public Genero toGenero() {
        return new Genero(this.id, this.nombre);
    }
}
