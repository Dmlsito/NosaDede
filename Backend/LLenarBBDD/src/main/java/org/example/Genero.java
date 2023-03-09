package org.example;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Generos")
public class Genero implements java.io.Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "Nombre")
    private String nombre;

    @OneToMany(mappedBy = "genero")
    private Set<GenerosPeliculas> generosPeliculas;

    public Genero() {
    }

    public Genero(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Genero(String nombre) {
        this.nombre = nombre;
    }

    public Set<GenerosPeliculas> getGenerosPeliculas() {
        return generosPeliculas;
    }

    public void setGenerosPeliculas(Set<GenerosPeliculas> generosPeliculas) {
        this.generosPeliculas = generosPeliculas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
