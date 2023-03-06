package es.nosadd.nosadd.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Directores")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Director {
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
    @Column(name = "Imagen_Director")
    private String imagenDirector;

    public Director(String nombre, String apellidos, String fechaNacimiento, String nacionalidad, String historia, int valoracion, String imagenDirector) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.historia = historia;
        this.valoracion = valoracion;
        this.imagenDirector = imagenDirector;
    }

}
