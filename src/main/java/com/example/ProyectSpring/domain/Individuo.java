package com.example.ProyectSpring.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import java.io.Serializable;
import lombok.Data;



@Data
@Entity
@Table(name = "individuo")
public class Individuo implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotEmpty(message = "El Nombre no puede estar vacío")
    private String nombre;
    
    @NotEmpty(message = "El Apellido no puede estar vacío")
    private String apellido;
    
    @NotEmpty(message = "El teléfono no puede estar vacío")
    @Pattern(regexp = "^[0-9]{1,9}$", message = "El teléfono debe contener solo números y un máximo de 9 dígitos")
    private String telefono;
    
    @NotEmpty(message = "El Correo no puede estar vacío")
    @Email
    private String correo;
    
    @NotEmpty(message = "La Edad no puede estar vacío")
    @Pattern(regexp = "\\d+", message = "La edad debe ser un número entero positivo")
    private String edad;
    
    @Column(nullable = false)
    private Boolean activo = true;
}
