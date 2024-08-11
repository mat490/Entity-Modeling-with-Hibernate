package edu.unam.proyecto.avance.model;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "estados_civiles")
public class EstadosCiviles {
    @Id
    @Column(name = "id_estado_civil")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nombre_estado_civil")
    private String estadoCivil;

    @Override
    public String toString(){
        return  "ID: "+getId() +  " Estado civil: "+getEstadoCivil();
    }
}
