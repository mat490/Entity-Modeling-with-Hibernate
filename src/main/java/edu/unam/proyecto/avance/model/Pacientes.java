package edu.unam.proyecto.avance.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "pacientes")
public class Pacientes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Paciente")
    private Integer id;

    /*Relaciones*/

    //ID_Datos_Personales_Generales NOT NULL,
    @ManyToOne(targetEntity = DatosPersonalesGenerales.class, fetch = FetchType.LAZY)
    @JoinColumn (name = "ID_Datos_Personales_Generales", nullable = false, unique = true)
    @Fetch(FetchMode.JOIN)
    private DatosPersonalesGenerales datosPersonaels;

    // ID_Estado_Civil INT NOT NULL,
    @ManyToOne(targetEntity = EstadosCiviles.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_Estado_Civil", nullable = false)
    @Fetch(FetchMode.JOIN)
    private EstadosCiviles estadoCivil;

    // ID_Ocupacion INT NOT NULL,
    @ManyToOne(targetEntity = Ocupaciones.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_Ocupacion", nullable = false)
    @Fetch(FetchMode.JOIN)
    private Ocupaciones ocupacion;

    // ID_COMBE INT NOT NULL,
    @ManyToOne(targetEntity = Combe.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_COMBE", nullable = false)
    @Fetch(FetchMode.JOIN)
    private Combe combe;

    // ID_Grupo_Sanguineo INT NOT NULL,
    @ManyToOne(targetEntity = GruposSanguineos.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_Grupo_Sanguineo", nullable = false)
    @Fetch(FetchMode.JOIN)
    private GruposSanguineos grupoSanguineo;

    // ID_RH INT NOT NULL,
    @ManyToOne(targetEntity = Rh.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_RH", nullable = false)
    @Fetch(FetchMode.JOIN)
    private Rh rh;

    // ID_Lugar_Nacimiento INT NOT NULL,
    @ManyToOne(targetEntity = LugaresNacimiento.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_Lugar_Nacimiento", nullable = false)
    @Fetch(FetchMode.JOIN)
    private LugaresNacimiento lugarNacimiento;

    @Override
    public String toString(){
        return "Paciente: "+datosPersonaels.getNombre()+" "+ datosPersonaels.getNombre2()+ " "+ datosPersonaels.getApellido1()+ " "+ datosPersonaels.getApellido2()+ "\n"+
                "Grupo sanguineo: " +grupoSanguineo.getGrupoSanguineo()+" RH: "+rh.getRh()+". COMBE: "+combe.getCombe()+". Ocupacion: "+ocupacion.getOcupacion()+". Lugar de Nacimiento: "+lugarNacimiento+"\n";
    }
}
