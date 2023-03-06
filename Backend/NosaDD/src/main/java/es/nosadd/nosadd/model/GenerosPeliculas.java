package es.nosadd.nosadd.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "GenerosPeliculas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenerosPeliculas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int idGenero;
    private int idPelicula;
    @ManyToOne
    @JoinColumn(name = "idGenero", insertable = false, updatable = false, referencedColumnName = "id")
    private Genero genero;
    @ManyToOne
    @JoinColumn(name = "idPelicula", insertable = false, updatable = false, referencedColumnName = "id")
    private Pelicula pelicula;

    public GenerosPeliculas(int id, int idGenero, int idPelicula) {
        this.idGenero = idGenero;
        this.idPelicula = idPelicula;
    }

}
