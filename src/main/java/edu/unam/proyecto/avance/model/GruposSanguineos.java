package edu.unam.proyecto.avance.model;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "grupos_sanguineos")
public class GruposSanguineos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Grupo_Sanguineo")
    private Integer id;
    @Column(name = "grupo_sanguineo", length = 2)
    private String grupoSanguineo;

    @Override
    public String toString(){
        return "ID: "+id+" Grupo sanguineo: "+grupoSanguineo;
    }
}
