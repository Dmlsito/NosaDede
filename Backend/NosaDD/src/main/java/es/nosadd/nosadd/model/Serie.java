package es.nosadd.nosadd.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Series")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Serie {

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
    @Column(name = "Imagen_Serie")
    private String imagenSerie;
    @Column(name = "Temporadas")
    private int temporadas;
    @Column(name = "Capitulos")
    private int capitulos;

    public Serie(String titulo, String duracion, String resumen, int valoracion, String imagenSerie, int temporadas, int capitulos) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.resumen = resumen;
        this.valoracion = valoracion;
        this.imagenSerie = imagenSerie;
        this.temporadas = temporadas;
        this.capitulos = capitulos;
    }
}
