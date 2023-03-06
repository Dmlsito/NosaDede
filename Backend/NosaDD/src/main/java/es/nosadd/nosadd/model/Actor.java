package es.nosadd.nosadd.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Actores")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Apellidos")
    private String apellidos;
    @Column(name = "Fecha_Nacimiento")
    private String fechaNacimiento;
    @Column(name = "Nacionalidad")
    private String nacionalidad;
    @Column(name = "Historia")
    private String historia;
    @Column(name = "Valoracion")
    private int valoracion;
    @Column(name = "Imagen_Actor")
    private String imagenActor;

    public Actor(String nombre, String apellidos, String fechaNacimiento, String nacionalidad, String historia, int valoracion, String imagenActor) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.historia = historia;
        this.valoracion = valoracion;
        this.imagenActor = imagenActor;
    }
}
