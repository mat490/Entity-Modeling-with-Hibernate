package edu.unam.proyecto.avance.model;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "ocupaciones")
public class Ocupaciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Ocupacion")
    private Integer id;
    @Column(name = "ocupacion")
    private String ocupacion;

    @Override
    public String toString(){
        return "ID: "+ocupacion+" Ocupación: "+ocupacion;
    }
}
