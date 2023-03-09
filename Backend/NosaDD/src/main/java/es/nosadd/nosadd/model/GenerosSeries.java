package es.nosadd.nosadd.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "GenerosSeries")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenerosSeries {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "idGenero")
    private int idGenero;
    @Column(name = "idSerie")
    private int idSerie;

    @ManyToOne
    @JoinColumn(name = "idGenero", insertable = false, updatable = false, referencedColumnName = "id")
    private Genero genero;

    @ManyToOne
    @JoinColumn(name = "idSerie", insertable = false, updatable = false, referencedColumnName = "id")
    private Serie serie;

    public GenerosSeries(int id, int idGenero, int idSerie) {
        this.id = id;
        this.idGenero = idGenero;
        this.idSerie = idSerie;
    }
}
