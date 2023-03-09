package org.example;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Peliculas")
public class Pelicula implements java.io.Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "Titulo")
    private String titulo;
    @Column(name = "Duracion")
    private String duracion;
    @Column(name = "Resumen")
    private String resumen;
    @Column(name = "Valoracion")
    private int valoracion;
    @Column(name = "Imagen_Pelicula")
    private String imagenPelicula;

    @OneToMany(mappedBy = "pelicula")
    private Set<GenerosPeliculas> generosPeliculas;

    public Pelicula(int id, String titulo, String duracion, String resumen, int valoracion, String imagenPelicula) {
        this.id = id;
        this.titulo = titulo;
        this.duracion = duracion;
        this.resumen = resumen;
        this.valoracion = valoracion;
        this.imagenPelicula = imagenPelicula;
    }

    public Pelicula() {
    }

    public Pelicula(String titulo, String duracion, String resumen, int valoracion, String imagenPelicula) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.resumen = resumen;
        this.valoracion = valoracion;
        this.imagenPelicula = imagenPelicula;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public int getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }

    public String getImagenPelicula() {
        return imagenPelicula;
    }

    public void setImagenPelicula(String imagenPelicula) {
        this.imagenPelicula = imagenPelicula;
    }

    public Set<GenerosPeliculas> getGenerosPeliculas() {
        return generosPeliculas;
    }

    public void setGenerosPeliculas(Set<GenerosPeliculas> generosPeliculas) {
        this.generosPeliculas = generosPeliculas;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", duracion='" + duracion + '\'' +
                ", resumen='" + resumen + '\'' +
                ", valoracion=" + valoracion +
                ", imagenPelicula='" + imagenPelicula + '\'' +
                ", generosPeliculas=" + generosPeliculas +
                '}';
    }
}
