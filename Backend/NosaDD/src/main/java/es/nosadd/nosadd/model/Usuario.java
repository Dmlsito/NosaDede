package es.nosadd.nosadd.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Usuarios")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Apellidos")
    private String apellidos;

    @Column(name = "Nombre_Usuario")
    private String nombreUsuario;

    @Column(name = "Imagen_Usuario")
    private String imagenUsuario;

    @Column(name = "Correo_Electronico")
    private String correoElectronico;

    @Column(name = "Contrasena")
    private String contrasena;

}
