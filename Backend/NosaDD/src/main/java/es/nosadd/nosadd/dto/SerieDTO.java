package es.nosadd.nosadd.dto;

import es.nosadd.nosadd.model.Serie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SerieDTO {

    private int id;
    private String titulo;
    private String duracion;
    private String resumen;
    private int valoracion;
    private String imagenSerie;
    private int temporadas;
    private int capitulos;

    public SerieDTO(String titulo, String duracion, String resumen, int valoracion, String imagenSerie, int temporadas, int capitulos) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.resumen = resumen;
        this.valoracion = valoracion;
        this.imagenSerie = imagenSerie;
        this.temporadas = temporadas;
        this.capitulos = capitulos;
    }

    public Serie toSerie() {
        return new Serie(this.id, this.titulo, this.duracion, this.resumen, this.valoracion, this.imagenSerie, this.temporadas, this.capitulos);
    }

    public SerieDTO fromSerie(Serie serie) {
        return new SerieDTO(serie.getId(), serie.getTitulo(), serie.getDuracion(), serie.getResumen(), serie.getValoracion(), serie.getImagenSerie(), serie.getTemporadas(), serie.getCapitulos());
    }
}
