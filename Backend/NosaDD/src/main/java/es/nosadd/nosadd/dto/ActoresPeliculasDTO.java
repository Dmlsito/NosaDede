package es.nosadd.nosadd.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import es.nosadd.nosadd.model.ActoresPeliculas;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActoresPeliculasDTO {

    private int id;
    private int idActor;
    private int idPelicula;

    public ActoresPeliculasDTO(int idActor, int idPelicula) {
        this.idActor = idActor;
        this.idPelicula = idPelicula;
    }

    public ActoresPeliculasDTO fromActoresPeliculas(ActoresPeliculas actoresPeliculas) {
        return new ActoresPeliculasDTO(actoresPeliculas.getId(), actoresPeliculas.getIdActor(), actoresPeliculas.getIdPelicula());
    }

    public ActoresPeliculas toActoresPeliculas() {
        return new ActoresPeliculas(this.id, this.idActor, this.idPelicula);
    }

}
