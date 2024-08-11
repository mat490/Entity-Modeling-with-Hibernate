package edu.unam.proyecto.avance.view.impl;

import edu.unam.proyecto.avance.model.EstadosCiviles;
import edu.unam.proyecto.avance.service.GenericDAOService;
import edu.unam.proyecto.avance.service.impl.EstadosCivilesServiceImpl;
import edu.unam.proyecto.avance.view.Menu;
import edu.unam.proyecto.avance.view.TablesUI;

import java.util.List;
import java.util.Scanner;

public class EstadosCivilesMenuImpl implements TablesUI {
    private static EstadosCivilesMenuImpl instance;
    private static final GenericDAOService estadoCivilService = EstadosCivilesServiceImpl.getInstance();
    Menu menuPrincipal = MenuImpl.getInstance();
    Scanner sn;

    public static EstadosCivilesMenuImpl getInstance(){
        if (instance == null){
            instance = new EstadosCivilesMenuImpl();
        }
        return instance;
    }

    private EstadosCivilesMenuImpl(){

    }

    @Override
    public void mensajeMenu() {
        int opcion;
        System.out.println("######### Menu catálogo estados civiles #########");
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
        String estadoCivil;
        EstadosCiviles nuevoEstadoCivil = new EstadosCiviles();
        sn = new Scanner(System.in);
        System.out.println("----- Insertar un nuevo valor en tabla -----");
        System.out.println(">> Escriba el nombre del estado civil << \n");
        estadoCivil = sn.nextLine();
        nuevoEstadoCivil.setEstadoCivil(estadoCivil);
        //
        estadoCivilService.insertEntity(nuevoEstadoCivil);
        System.out.println(nuevoEstadoCivil.getEstadoCivil() +" insertado correctamente");
        mensajeMenu();
    }

    @Override
    public void updateEntradas() {
        String estadoCivil;
        int id;
        EstadosCiviles estadoCivilActualizado = new EstadosCiviles();
        sn = new Scanner(System.in);
        //
        System.out.println("----- Insertar un nuevo valor en tabla -----");
        System.out.println(">> Escriba el id del estado civil que desea actualizar << \n");
        id = sn.nextInt();
        estadoCivilActualizado.setId(id);
        sn.nextLine();
        //
        System.out.println(">> Escriba el nombre del estado civil << \n");
        estadoCivil = sn.nextLine();
        estadoCivilActualizado.setEstadoCivil(estadoCivil);
        //
        estadoCivilService.updateEntity(estadoCivilActualizado);
        System.out.println(estadoCivilActualizado.getEstadoCivil()+" actualizado correctamente");
        mensajeMenu();
    }

    @Override
    public void deleteEntradas() {
        int id;
        System.out.println("----- Borrar un registro en tabla -----");
        System.out.println(">> Escriba el id del estado civil que desea borrar <<");
        id = sn.nextInt();
        //
        estadoCivilService.delete(estadoCivilService.getByID(id));
        System.out.println("Se borró correctamente");
        mensajeMenu();

    }

    @Override
    public void selectsEntradas() {
        List<EstadosCiviles> estadosCivilesList;
        int id;
        int opcion;
        EstadosCiviles estadoCivil = new EstadosCiviles();
        System.out.println("----- Ver registros en la tabla -----");
        System.out.println("1. Seleccionar un registro por su id");
        System.out.println("2. Ver todos los registros en la tabla estados civiles");
        System.out.println("3. Regresar");
        System.out.println(">> Ingrese la opcion deseada <<");

        opcion = sn.nextInt();
        sn.nextLine();

        if (opcion == 1) {
            System.out.println(">> Porfavor ingrese el ID del registro deseado >>");
            id = sn.nextInt();
            estadoCivil = (EstadosCiviles) estadoCivilService.getByID(id);
            System.out.println("Registro encontrado: "+estadoCivil.getEstadoCivil());

        } else if (opcion == 2) {
            System.out.println("------ Todos los registros ------");
            estadosCivilesList = estadoCivilService.getAll();
            for (EstadosCiviles estadoCivilEncontrado : estadosCivilesList){
                System.out.println("------- Registro con ID: "+estadoCivilEncontrado.getId()+" -------");
                System.out.println(estadoCivilEncontrado.getEstadoCivil());
                System.out.println("---------------------------------\n");

            }
            mensajeMenu();
        } else if (opcion == 3) {
            mensajeMenu();
            
        }

    }
}
