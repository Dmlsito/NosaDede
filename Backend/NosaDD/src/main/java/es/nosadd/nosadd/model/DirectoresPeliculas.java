package es.nosadd.nosadd.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "DirectoresPeliculas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DirectoresPeliculas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "idDirector")
    private int idDirector;
    @Column(name = "idPelicula")
    private int idPelicula;

    @ManyToOne
    @JoinColumn(name = "idDirector", insertable = false, updatable = false, referencedColumnName = "id")
    private Director director;

    @ManyToOne
    @JoinColumn(name = "idPelicula", insertable = false, updatable = false, referencedColumnName = "id")
    private Pelicula pelicula;

    public DirectoresPeliculas(int id, int idDirector, int idPelicula) {
        this.id = id;
        this.idDirector = idDirector;
        this.idPelicula = idPelicula;
    }
}
