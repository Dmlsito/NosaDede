package es.nosadd.nosadd.dto;

import es.nosadd.nosadd.model.Pelicula;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PeliculaDTO {

    private int id;
    private String titulo;
    private String duracion;
    private String resumen;
    private int valoracion;
    private String imagenPelicula;

    public PeliculaDTO(String titulo, String duracion, String resumen, int valoracion, String imagenPelicula) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.resumen = resumen;
        this.valoracion = valoracion;
        this.imagenPelicula = imagenPelicula;
    }

    public Pelicula toPelicula() {
        return new Pelicula(this.id, this.titulo, this.duracion, this.resumen, this.valoracion, this.imagenPelicula);
    }

    public PeliculaDTO fromPelicula(Pelicula pelicula) {
        return new PeliculaDTO(pelicula.getId(), pelicula.getTitulo(), pelicula.getDuracion(), pelicula.getResumen(), pelicula.getValoracion(), pelicula.getImagenPelicula());
    }
}
