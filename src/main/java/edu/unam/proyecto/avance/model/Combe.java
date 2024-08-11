package edu.unam.proyecto.avance.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "Combe")
public class Combe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_COMBE")
    private Integer id;
    @Column(name = "combe")
    private String combe;

    @Override
    public String toString(){
        return "ID: "+id+" COMBE: "+combe;
    }
}
