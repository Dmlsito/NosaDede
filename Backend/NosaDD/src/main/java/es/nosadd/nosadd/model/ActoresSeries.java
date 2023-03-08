package es.nosadd.nosadd.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ActoresSeries")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActoresSeries {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "IdActor")
    private int idActor;
    @Column(name = "IdSerie")
    private int idSerie;

    @ManyToOne
    @JoinColumn(name = "IdActor", insertable = false, updatable = false, referencedColumnName = "id")
    private Actor actor;

    @ManyToOne
    @JoinColumn(name = "IdSerie", insertable = false, updatable = false, referencedColumnName = "id")
    private Serie serie;

    public ActoresSeries(int id, int idActor, int idSerie) {
        this.id = id;
        this.idActor = idActor;
        this.idSerie = idSerie;
    }
}
