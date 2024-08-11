package edu.unam.proyecto.avance.view.impl;

import edu.unam.proyecto.avance.model.*;
import edu.unam.proyecto.avance.service.impl.*;
import edu.unam.proyecto.avance.view.Menu;
import edu.unam.proyecto.avance.view.TablesUI;
import edu.unam.proyecto.avance.service.GenericDAOService;

import java.util.List;
import java.util.Scanner;

public class PacientesMenuImpl implements TablesUI {
    private static final GenericDAOService pacienteService = PacientesServiceImpl.getInstance();
    private static final GenericDAOService datosPersonalesService = DatosPersonalesGeneralesServiceImpl.getInstance();
    private static final GenericDAOService estadoCivilService = EstadosCivilesServiceImpl.getInstance();
    private static final GenericDAOService combeService = CombeServiceImpl.getInstance();
    private static final GenericDAOService ocupacionService = OcupacionesServiceImpl.getInstance();
    private static final GenericDAOService grupoSanguineoService = GruposSanguineosServiceImpl.getInstance();
    private static final GenericDAOService rhService = RhServiceImpl.getInstance();
    private static final GenericDAOService lugarNacimientoService = LugaresNacimientoServiceImpl.getInstance();
    //
    Scanner sn;
    Menu menuPrincipal =  MenuImpl.getInstance();
    private static PacientesMenuImpl instance;

    public static  PacientesMenuImpl getInstance() {
        if (instance == null){
            instance = new PacientesMenuImpl();
        }
        return instance;
    }

    private PacientesMenuImpl (){

    }
    @Override
    public void mensajeMenu() {
        int opcion;
        System.out.println("######### Menu catálogo pacientes #########");
        System.out.println("-------------- Opciones -----------------");
        System.out.println("1. Ver registros en la tabla");
        System.out.println("2. Insertar un nuevo registro en la tabla");
        System.out.println("3. Actualizar un registro en la tabla");
        System.out.println("4. Borrar un registro en la tabla");
        System.out.println("5. Regresar");

        System.out.println("\n >> Ingrese la opción deseada <<");
        sn = new Scanner(System.in);
        opcion = sn.nextInt();

        switch (opcion){
            case 1:
                selectsEntradas();
                break;
            case 2:
                insertEntradas();
                break;
            case 3:
                updateEntradas();
                break;
            case 4:
                deleteEntradas();
                break;
            case 5:
                menuPrincipal.menuMessage();
                break;
            default:
                break;


        }
    }

    @Override
    public void insertEntradas() {
        int id;
        sn = new Scanner(System.in);
        Pacientes nuevoPaciente = new Pacientes();
        DatosPersonalesGenerales datosPersonalesGenerales;
        //
        System.out.println("--------- Insertar un nuevo valor en tabla ---------");
        System.out.println("****** Datos Personales Generales disponibles ******");
        List<DatosPersonalesGenerales> datosPersonalesGeneralesList = datosPersonalesService.getAll();
        for (DatosPersonalesGenerales datosPersonalesGeneralesEncontrado: datosPersonalesGeneralesList){
            System.out.println("----------------- ID: " +datosPersonalesGeneralesEncontrado.getId()+ " ------------------");
            System.out.println(datosPersonalesGeneralesEncontrado);
            System.out.println("---------------------------------------------");
        }
        System.out.println("***************************************************");
        //
        System.out.println(">> Ingrese el id de los datos personales del paciente <<");
        id = sn.nextInt();
        sn.nextLine();
        datosPersonalesGenerales = (DatosPersonalesGenerales) datosPersonalesService.getByID(id);
        nuevoPaciente.setDatosPersonaels(datosPersonalesGenerales);
        //
        System.out.println("***** Estados Civiles disponibles ******");
        List<EstadosCiviles> estadosCivilesList = estadoCivilService.getAll();
        EstadosCiviles estadoCivil;
        for (EstadosCiviles estadoCivilEncontrado: estadosCivilesList){
            System.out.println("-----------------------------------");
            System.out.println(estadoCivilEncontrado);
            System.out.println("-----------------------------------");
        }
        System.out.println("****************************************");
        //
        System.out.println(">> Ingrese el id del estado civil correcto <<");
        id = sn.nextInt();
        sn.nextLine();
        estadoCivil = (EstadosCiviles) estadoCivilService.getByID(id);
        nuevoPaciente.setEstadoCivil(estadoCivil);
        //
        System.out.println("***** Ocupaciones disponibles ******");
        List<Ocupaciones> ocupacionesList = ocupacionService.getAll();
        Ocupaciones ocupacion;
        for (Ocupaciones ocupacionEncontrada : ocupacionesList){
            System.out.println("-----------------------------------");
            System.out.println(ocupacionEncontrada);
            System.out.println("-----------------------------------");
        }
        System.out.println("****************************************");
        //
        System.out.println(">> Ingrese el id de la ocupación correcta <<");
        id = sn.nextInt();
        sn.nextLine();
        nuevoPaciente.setOcupacion((Ocupaciones) ocupacionService.getByID(id));
        //
        System.out.println("***** Opciones de COMBE disponibles *****");
        List<Combe> combeList = combeService.getAll();
        for (Combe combeEncontrada: combeList){
            System.out.println("-------------------------------------");
            System.out.println(combeEncontrada);
            System.out.println("-------------------------------------");

        }
        System.out.println("*****************************************");
        //
        System.out.println(">> Ingrese el id del COMBE del paciente <<");
        id = sn.nextInt();
        sn.nextLine();
        nuevoPaciente.setCombe((Combe) combeService.getByID(id));
        //
        System.out.println("***** Grupos Sanguineos disponibles ******");
        List<GruposSanguineos> gruposSanguineosList = grupoSanguineoService.getAll();
        for (GruposSanguineos grupoSanguineoEncontrado: gruposSanguineosList ){
            System.out.println("-------------------------------------");
            System.out.println(grupoSanguineoEncontrado);
            System.out.println("-------------------------------------");
        }
        System.out.println("******************************************");
        //
        System.out.println(">> Ingrese el id del Grupo Sanguineo del paciente <<");
        id = sn.nextInt();
        sn.nextLine();
        nuevoPaciente.setGrupoSanguineo((GruposSanguineos) grupoSanguineoService.getByID(id));
        //
        System.out.println("***** RHs disponibles ******");
        List<Rh> rhList = rhService.getAll();
        for (Rh rhEncontrado : rhList){
            System.out.println("-------------------------------------");
            System.out.println(rhEncontrado);
            System.out.println("-------------------------------------");
        }
        System.out.println("****************************************");
        //
        System.out.println(">> Ingrese el id del RH correcto <<");
        id = sn.nextInt();
        sn.nextLine();
        nuevoPaciente.setRh((Rh) rhService.getByID(id));
        System.out.println("***** Lugares de Nacimiento disponibles ******");
        List<LugaresNacimiento> lugaresNacimientoList = lugarNacimientoService.getAll();
        for (LugaresNacimiento lugaresNacimiento: lugaresNacimientoList){
            System.out.println("-------------------------------------");
            System.out.println(lugaresNacimiento);
            System.out.println("-------------------------------------");
        }
        System.out.println("*********************************************");
        System.out.println(">> Ingrese el id del lugar de nacimiento del paciente <<");
        id = sn.nextInt();
        nuevoPaciente.setLugarNacimiento((LugaresNacimiento) lugarNacimientoService.getByID(id));
        //
        pacienteService.insertEntity(nuevoPaciente);
        System.out.println(nuevoPaciente+" insertado correctamente.");
        mensajeMenu();

    }

    @Override
    public void updateEntradas() {
        int id;
        sn = new Scanner(System.in);
        Pacientes nuevoPaciente = new Pacientes();
        DatosPersonalesGenerales datosPersonalesGenerales;
        //
        System.out.println("--------- Acualizar registro en tabla ---------");
        System.out.println(">> Ingrese el id del paciente que desea actualizar <<");
        id = sn.nextInt();
        sn.nextLine();
        nuevoPaciente.setId(id);
        //
        System.out.println("****** Datos Personales Generales disponibles ******");
        List<DatosPersonalesGenerales> datosPersonalesGeneralesList = datosPersonalesService.getAll();
        for (DatosPersonalesGenerales datosPersonalesGeneralesEncontrado: datosPersonalesGeneralesList){
            System.out.println("----------------- ID: " +datosPersonalesGeneralesEncontrado.getId()+ " ------------------");
            System.out.println(datosPersonalesGeneralesEncontrado);
            System.out.println("---------------------------------------------");
        }
        System.out.println("***************************************************");
        //
        System.out.println(">> Ingrese el id de los datos personales del paciente <<");
        id = sn.nextInt();
        sn.nextLine();
        datosPersonalesGenerales = (DatosPersonalesGenerales) datosPersonalesService.getByID(id);
        nuevoPaciente.setDatosPersonaels(datosPersonalesGenerales);
        //
        System.out.println("***** Estados Civiles disponibles ******");
        List<EstadosCiviles> estadosCivilesList = estadoCivilService.getAll();
        EstadosCiviles estadoCivil;
        for (EstadosCiviles estadoCivilEncontrado: estadosCivilesList){
            System.out.println("-----------------------------------");
            System.out.println(estadoCivilEncontrado);
            System.out.println("-----------------------------------");
        }
        System.out.println("****************************************");
        //
        System.out.println(">> Ingrese el id del estado civil correcto <<");
        id = sn.nextInt();
        sn.nextLine();
        estadoCivil = (EstadosCiviles) estadoCivilService.getByID(id);
        nuevoPaciente.setEstadoCivil(estadoCivil);
        //
        System.out.println("***** Ocupaciones disponibles ******");
        List<Ocupaciones> ocupacionesList = ocupacionService.getAll();
        Ocupaciones ocupacion;
        for (Ocupaciones ocupacionEncontrada : ocupacionesList){
            System.out.println("-----------------------------------");
            System.out.println(ocupacionEncontrada);
            System.out.println("-----------------------------------");
        }
        System.out.println("****************************************");
        //
        System.out.println(">> Ingrese el id de la ocupación correcta <<");
        id = sn.nextInt();
        sn.nextLine();
        nuevoPaciente.setOcupacion((Ocupaciones) ocupacionService.getByID(id));
        //
        System.out.println("***** Opciones de COMBE disponibles *****");
        List<Combe> combeList = combeService.getAll();
        for (Combe combeEncontrada: combeList){
            System.out.println("-------------------------------------");
            System.out.println(combeEncontrada);
            System.out.println("-------------------------------------");

        }
        System.out.println("*****************************************");
        //
        System.out.println(">> Ingrese el id del COMBE del paciente <<");
        id = sn.nextInt();
        sn.nextLine();
        nuevoPaciente.setCombe((Combe) combeService.getByID(id));
        //
        System.out.println("***** Grupos Sanguineos disponibles ******");
        List<GruposSanguineos> gruposSanguineosList = grupoSanguineoService.getAll();
        for (GruposSanguineos grupoSanguineoEncontrado: gruposSanguineosList ){
            System.out.println("-------------------------------------");
            System.out.println(grupoSanguineoEncontrado);
            System.out.println("-------------------------------------");
        }
        System.out.println("******************************************");
        //
        System.out.println(">> Ingrese el id del Grupo Sanguineo del paciente <<");
        id = sn.nextInt();
        sn.nextLine();
        nuevoPaciente.setGrupoSanguineo((GruposSanguineos) grupoSanguineoService.getByID(id));
        //
        System.out.println("***** RHs disponibles ******");
        List<Rh> rhList = rhService.getAll();
        for (Rh rhEncontrado : rhList){
            System.out.println("-------------------------------------");
            System.out.println(rhEncontrado);
            System.out.println("-------------------------------------");
        }
        System.out.println("****************************************");
        //
        System.out.println(">> Ingrese el id del RH correcto <<");
        id = sn.nextInt();
        sn.nextLine();
        nuevoPaciente.setRh((Rh) rhService.getByID(id));
        System.out.println("***** Lugares de Nacimiento disponibles ******");
        List<LugaresNacimiento> lugaresNacimientoList = lugarNacimientoService.getAll();
        for (LugaresNacimiento lugaresNacimiento: lugaresNacimientoList){
            System.out.println("-------------------------------------");
            System.out.println(lugaresNacimiento);
            System.out.println("-------------------------------------");
        }
        System.out.println("*********************************************");
        System.out.println(">> Ingrese el id del lugar de nacimiento del paciente <<");
        id = sn.nextInt();
        nuevoPaciente.setLugarNacimiento((LugaresNacimiento) lugarNacimientoService.getByID(id));
        //
        pacienteService.updateEntity(nuevoPaciente);
        System.out.println(nuevoPaciente+" actualizado correctamente.");
        mensajeMenu();
    }

    @Override
    public void deleteEntradas() {
        int id;
        System.out.println("----- Borrar un registro en tabla -----");
        System.out.println(">> Escriba el id del paciente que desea borrar <<");
        id = sn.nextInt();
        sn.nextLine();
        //
        pacienteService.delete(pacienteService.getByID(id));
        System.out.println("Se borró correctamente");
        mensajeMenu();
    }

    @Override
    public void selectsEntradas() {
        List<Pacientes> pacientesList;
        Pacientes paciente;
        int id;
        int opcion;
        System.out.println("----- Ver registros en la tabla -----");
        System.out.println("1. Seleccionar un registro por su id");
        System.out.println("2. Ver todos los registros en la tabla estados civiles");
        System.out.println("3. Regresar");
        System.out.println(">> Ingrese la opcion deseada <<");

        opcion = sn.nextInt();
        sn.nextLine();
        if (opcion == 1){
            System.out.println(">> Porfavor ingrese el ID del registro deseado >>");
            id = sn.nextInt();
            paciente = (Pacientes) pacienteService.getByID(id);
            System.out.println("Registro encontrado: "+paciente);
        } else if (opcion == 2) {
            System.out.println("------ Todos los registros ------");
            pacientesList = pacienteService.getAll();
            for (Pacientes pacienteEncontrado: pacientesList){
                System.out.println("------- Registro con ID: "+pacienteEncontrado.getId()+" -------");
                System.out.println(pacienteEncontrado);
                System.out.println("---------------------------------\n");
            }
            
        } else if (opcion == 3) {
           mensajeMenu();
        }
        mensajeMenu();

    }
}
