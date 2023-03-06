package es.nosadd.nosadd.dto;

import es.nosadd.nosadd.model.Actor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActorDTO {

    private int id;
    private String nombre;
    private String apellidos;
    private String fechaNacimiento;
    private String nacionalidad;
    private String historia;
    private int valoracion;
    private String imagenActor;

    public ActorDTO(String nombre, String apellidos, String fechaNacimiento, String nacionalidad, String historia, int valoracion, String imagenActor) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.historia = historia;
        this.valoracion = valoracion;
        this.imagenActor = imagenActor;
    }

    public Actor toActor() {
        return new Actor(this.id, this.nombre, this.apellidos, this.fechaNacimiento, this.nacionalidad, this.historia, this.valoracion, this.imagenActor);
    }

    public ActorDTO fromActor(Actor actor) {
        return new ActorDTO(actor.getId(), actor.getNombre(), actor.getApellidos(), actor.getFechaNacimiento(), actor.getNacionalidad(), actor.getHistoria(), actor.getValoracion(), actor.getImagenActor());
    }
}
