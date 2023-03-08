package es.nosadd.nosadd.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "Peliculas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pelicula {

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


    public Pelicula(String titulo, String duracion, String resumen, int valoracion, String imagenPelicula) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.resumen = resumen;
        this.valoracion = valoracion;
        this.imagenPelicula = imagenPelicula;
    }
}
