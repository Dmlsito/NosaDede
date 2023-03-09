package es.nosadd.nosadd.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "DirectoresSeries")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DirectoresSeries {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "idDirector")
    private int idDirector;
    @Column(name = "idSerie")
    private int idSerie;

    @ManyToOne
    @JoinColumn(name = "idDirector", insertable = false, updatable = false, referencedColumnName = "id")
    private Director director;

    @ManyToOne
    @JoinColumn(name = "idSerie", insertable = false, updatable = false, referencedColumnName = "id")
    private Serie serie;

    public DirectoresSeries(int id, int idDirector, int idSerie) {
        this.id = id;
        this.idDirector = idDirector;
        this.idSerie = idSerie;
    }
}
