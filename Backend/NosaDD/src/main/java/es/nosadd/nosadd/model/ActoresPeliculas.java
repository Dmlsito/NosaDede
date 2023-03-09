package es.nosadd.nosadd.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ActoresPeliculas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActoresPeliculas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "IdActor")
    private int idActor;
    @Column(name = "IdPelicula")
    private int idPelicula;

    @ManyToOne
    @JoinColumn(name = "IdActor", insertable = false, updatable = false, referencedColumnName = "id")
    private Actor actor;

    @ManyToOne
    @JoinColumn(name = "IdPelicula", insertable = false, updatable = false, referencedColumnName = "id")
    private Pelicula pelicula;

    public ActoresPeliculas(int id, int idActor, int idPelicula) {
        this.id = id;
        this.idActor = idActor;
        this.idPelicula = idPelicula;
    }



}
