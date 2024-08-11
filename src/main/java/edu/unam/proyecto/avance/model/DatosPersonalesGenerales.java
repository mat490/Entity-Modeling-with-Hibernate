package edu.unam.proyecto.avance.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.time.LocalDate;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table (name = "datos_personales_generales")
public class DatosPersonalesGenerales {
    //(ID_Datos_Personales_Generales, nombre, nombre2, apellido1, apellido2, fecha_nacimiento, edad, telefono, correo_electronico, ID_Direccion, ID_Sexo)
    @Id
    @Column (name = "ID_Datos_Personales_Generales")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "nombre2")
    private String nombre2;
    @Column(name = "apellido1")
    private String apellido1;
    @Column(name = "apellido2")
    private String apellido2;
    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;
    @Column(name = "edad")
    private Integer edad;
    @Column(name = "telefono", nullable = false, unique = true)
    private String telefono;
    @Column(name = "correo_electronico",nullable = false, unique = true)
    private String correoElectronico;

    @ManyToOne(targetEntity = Direccion.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn (name = "ID_Direccion", nullable = false, unique = true)
    @Fetch(FetchMode.JOIN)
    private Direccion direccion;

    @ManyToOne(targetEntity = Sexo.class, fetch = FetchType.LAZY)
    @JoinColumn (name = "ID_Sexo", nullable = false, unique = true)
    @Fetch(FetchMode.JOIN)
    private Sexo sexo;

    @Override
    public String toString() {
        return "Datos Personales Generales de la persona con el ID "+id + ":\n"
                +"Nombre: "+nombre+"\n"
                +"Segundo nombre: "+nombre2+"\n"
                +"Apellido 1: "+apellido1+"\n"
                +"Apellido 2: "+apellido2+"\n"
                +"Fecha de nacimiento: "+fechaNacimiento+"\n"
                +"Edad: "+edad+"\n"
                +"Sexo: "+sexo+"\n"
                +"Telefono: "+telefono+"\n"
                +"Corre electrónico: "+correoElectronico+"\n"
                +"Dirección: "+direccion;
    }
}
