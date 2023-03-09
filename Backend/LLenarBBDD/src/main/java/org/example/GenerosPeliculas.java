package org.example;

import javax.persistence.*;

@Entity
@Table(name = "GenerosPeliculas")
public class GenerosPeliculas implements java.io.Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int idGenero;
    private int idPelicula;
    @ManyToOne()
    @JoinColumn(name = "idGenero", insertable = false, updatable = false, referencedColumnName = "id")
    private Genero genero;
    @ManyToOne()
    @JoinColumn(name = "idPelicula", insertable = false, updatable = false, referencedColumnName = "id")
    private Pelicula pelicula;

    public GenerosPeliculas() {
    }
    public GenerosPeliculas(int id, int idGenero, int idPelicula) {
        this.idGenero = idGenero;
        this.idPelicula = idPelicula;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }

    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    @Override
    public String toString() {
        return "Genero: " + genero.getNombre();
    }
}
