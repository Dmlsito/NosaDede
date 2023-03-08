package es.nosadd.nosadd.dto;

import es.nosadd.nosadd.model.GenerosSeries;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenerosSeriesDTO {

    private int id;
    private int idGenero;
    private int idSerie;

    public GenerosSeriesDTO(int idGenero, int idSerie) {
        this.idGenero = idGenero;
        this.idSerie = idSerie;
    }

    public GenerosSeriesDTO fromGenerosSeries(GenerosSeries generosSeries) {
        return new GenerosSeriesDTO(generosSeries.getId(), generosSeries.getIdGenero(), generosSeries.getIdSerie());
    }

    public GenerosSeries toGenerosSeries() {
        return new GenerosSeries(this.id, this.idGenero, this.idSerie);
    }
}
