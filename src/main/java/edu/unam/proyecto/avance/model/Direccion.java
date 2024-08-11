package edu.unam.proyecto.avance.model;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "direcciones")
public class Direccion {
    @Id
    @Column (name = "ID_Direccion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (name = "pais")
    private String pais;
    @Column (name = "estado")
    private String estado;
    @Column (name = "municipio")
    private String municipio;
    @Column (name = "colonia")
    private String colonia;
    @Column (name = "calle")
    private String calle;
    @Column (name = "numero_casa")
    private Integer numeroCasa;
    @Column (name = "codigo_postal")
    private String codigoPostal;

    @Override
    public String toString() {
        return "Dirección: \n"
                +"Calle: "+calle+". Número: "+numeroCasa+". Colonia: "+colonia+". Municipio: "+municipio +". C.P.: "
                + codigoPostal +". Estado: "+estado+". País: "+pais+".\n";
    }
}
