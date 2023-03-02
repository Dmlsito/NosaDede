package es.nosadd.nosadd.dto;

import es.nosadd.nosadd.model.Director;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DirectorDTO {

    private int id;
    private String nombre;
    private String apellidos;
    private String fechaNacimiento;
    private String nacionalidad;
    private String historia;
    private int valoracion;
    private String imagenDirector;

    public DirectorDTO(String nombre, String apellidos, String fechaNacimiento, String nacionalidad, String historia, int valoracion, String imagenDirector) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.historia = historia;
        this.valoracion = valoracion;
        this.imagenDirector = imagenDirector;
    }

    public Director toDirector() {
        return new Director(this.id, this.nombre, this.apellidos, this.fechaNacimiento, this.nacionalidad, this.historia, this.valoracion, this.imagenDirector);
    }

    public DirectorDTO fromDirector(Director director) {
        return new DirectorDTO(director.getId(), director.getNombre(), director.getApellidos(), director.getFechaNacimiento(), director.getNacionalidad(), director.getHistoria(), director.getValoracion(), director.getImagenDirector());
    }
}
