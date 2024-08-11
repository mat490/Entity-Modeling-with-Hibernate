package edu.unam.proyecto.avance.model;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table (name = "sexos")
public class Sexo {
    @Id
    @Column (name = "ID_Sexo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "sexo")
    private String sexo;

    @Override
    public String toString(){
        return "ID: "+id+". Sexo: "+sexo;
    }
}
