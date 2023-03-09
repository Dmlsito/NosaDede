package es.nosadd.nosadd.dto;

import es.nosadd.nosadd.model.DirectoresPeliculas;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DirectoresPeliculasDTO {

    private int id;
    private int idDirector;
    private int idPelicula;

    public DirectoresPeliculasDTO(int idDirector, int idPelicula) {
        this.idDirector = idDirector;
        this.idPelicula = idPelicula;
    }

    public DirectoresPeliculas toDirectoresPeliculas() {
        return new DirectoresPeliculas(this.id, this.idDirector, this.idPelicula);
    }

    public DirectoresPeliculasDTO fromDirectoresPeliculas(DirectoresPeliculas directoresPeliculas) {
        return new DirectoresPeliculasDTO(directoresPeliculas.getId(), directoresPeliculas.getIdDirector(), directoresPeliculas.getIdPelicula());
    }
}
