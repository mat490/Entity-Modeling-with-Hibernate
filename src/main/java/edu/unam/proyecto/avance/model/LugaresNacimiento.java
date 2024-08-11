package edu.unam.proyecto.avance.model;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Lugares_Nacimiento")
public class LugaresNacimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Lugar_Nacimiento")
    private Integer id;
    @Column(name = "pais")
    private String pais;
    @Column(name = "estado")
    private String estado;
    @Column(name = "municipio")
    private String municipio;

    @Override
    public String toString(){
        return "[ País: "+pais+". Estado: "+estado+". Municipio: "+municipio+".]";
    }

}
