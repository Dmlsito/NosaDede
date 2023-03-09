package es.nosadd.nosadd.dto;

import es.nosadd.nosadd.model.ActoresSeries;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActoresSeriesDTO {

    private int id;
    private int idActor;
    private int idSerie;

    public ActoresSeriesDTO(int idActor, int idSerie) {
        this.idActor = idActor;
        this.idSerie = idSerie;
    }

    public ActoresSeriesDTO fromActoresSeries(ActoresSeries actoresSeries) {
        return new ActoresSeriesDTO(actoresSeries.getId(), actoresSeries.getIdActor(), actoresSeries.getIdSerie());
    }

    public ActoresSeries toActoresSeries() {
        return new ActoresSeries(this.id, this.idActor, this.idSerie);
    }
}
