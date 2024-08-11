package edu.unam.proyecto.avance.model;

import jakarta.persistence.*;
import lombok.*;
import org.checkerframework.checker.units.qual.C;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "rh")
public class Rh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_RH")
    private Integer id;
    @Column(name = "RH")
    private String rh;


    @Override
    public String toString(){
        return "ID: "+getId()+" RH: "+getRh();
    }
}
