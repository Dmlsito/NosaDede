package es.nosadd.nosadd.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import es.nosadd.nosadd.model.DirectoresSeries;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DirectoresSeriesDTO {

    private int id;
    private int idDirector;
    private int idSerie;

    public DirectoresSeriesDTO(int idDirector, int idSerie) {
        this.idDirector = idDirector;
        this.idSerie = idSerie;
    }

    public DirectoresSeries toDirectoresSeries() {
        return new DirectoresSeries(this.id, this.idDirector, this.idSerie);
    }

    public DirectoresSeriesDTO fromDirectoresSeries(DirectoresSeries directoresSeries) {
        return new DirectoresSeriesDTO(directoresSeries.getId(), directoresSeries.getIdDirector(), directoresSeries.getIdSerie());
    }
}
