package org.example;

import javax.persistence.*;

@Entity
@Table(name = "Actores")
public class Actor implements java.io.Serializable{

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

    public Actor() {
    }

    public Actor(int id, String nombre, String apellidos, String fechaNacimiento, String nacionalidad, String historia, int valoracion, String imagenActor) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.historia = historia;
        this.valoracion = valoracion;
        this.imagenActor = imagenActor;
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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public int getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }

    public String getImagenActor() {
        return imagenActor;
    }

    public void setImagenActor(String imagenActor) {
        this.imagenActor = imagenActor;
    }
}
