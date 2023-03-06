package es.nosadd.nosadd.dto;

import es.nosadd.nosadd.model.GenerosPeliculas;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenerosPeliculasDTO {

    private int id;
    private int idGenero;
    private int idPelicula;

    public GenerosPeliculasDTO(int idGenero, int idPelicula) {
        this.idGenero = idGenero;
        this.idPelicula = idPelicula;
    }

    public GenerosPeliculasDTO fromGenerosPeliculas(GenerosPeliculasDTO generosPeliculas) {
        return new GenerosPeliculasDTO(generosPeliculas.getId(), generosPeliculas.getIdGenero(), generosPeliculas.getIdPelicula());
    }

    public GenerosPeliculas toGenerosPeliculas() {
        return new GenerosPeliculas(this.id, this.idGenero, this.idPelicula);
    }
}
