package edu.unam.proyecto.avance.view.impl;

import edu.unam.proyecto.avance.view.Menu;
import edu.unam.proyecto.avance.view.TablesUI;
import edu.unam.proyecto.avance.model.Ocupaciones;
import edu.unam.proyecto.avance.service.GenericDAOService;
import edu.unam.proyecto.avance.service.impl.OcupacionesServiceImpl;

import java.util.List;
import java.util.Scanner;

public class OcupacionesMenuImpl implements TablesUI {
    private static OcupacionesMenuImpl instance;

    Menu menuPrincipal = MenuImpl.getInstance();
    Scanner sn;

    private static final GenericDAOService ocupacionesService = OcupacionesServiceImpl.getInstance();




    public static OcupacionesMenuImpl getInstance() {
        if (instance == null){
            instance = new OcupacionesMenuImpl();
        }
        return instance;
    }

    private OcupacionesMenuImpl(){

    }

    @Override
    public void mensajeMenu() {
        int opcion;
        System.out.println("######### Menu catálogo ocupaciones #########");
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
        String ocupacion;
        Ocupaciones ocupacionNueva = new Ocupaciones();
        sn = new Scanner(System.in);
        System.out.println("----- Insertar un nuevo valor en tabla -----");
        System.out.println(">> Escriba el nombre de la ocupación << \n");
        ocupacion = sn.nextLine();

        ocupacionNueva.setOcupacion(ocupacion);
        ocupacionesService.insertEntity(ocupacionNueva);
        System.out.println(ocupacionNueva.getOcupacion() +" insertado correctamente");
        mensajeMenu();

    }

    @Override
    public void updateEntradas() {
        String ocupacion;
        int id;
        Ocupaciones ocupacionNueva = new Ocupaciones();
        sn = new Scanner(System.in);
        System.out.println("----- Insertar un nuevo valor en tabla -----");
        System.out.println(">> Escriba el id de la ocupación que desea actualizar << \n");
        id = sn.nextInt();
        ocupacionNueva.setId(id);
        //
        System.out.println(">> Escriba el nombre de la ocupación << \n");
        ocupacion = sn.nextLine();
        ocupacionNueva.setOcupacion(ocupacion);
        //
        ocupacionesService.insertEntity(ocupacionNueva);
        System.out.println(ocupacionNueva.getOcupacion() +" actualizado correctamente");
        mensajeMenu();
    }

    @Override
    public void deleteEntradas() {
        int id;
        System.out.println("----- Borrar un registro en tabla -----");
        System.out.println(">> Escriba el id de la ocupación que desea borrar <<");
        id = sn.nextInt();
        //
        ocupacionesService.delete(ocupacionesService.getByID(id));
        System.out.println("Se borró correctamente");
        mensajeMenu();

    }

    @Override
    public void selectsEntradas() {
        List<Ocupaciones> ocupacionesList;
        int id;
        int opcion;
        Ocupaciones ocupacion = new Ocupaciones();

        System.out.println("----- Ver registros en la tabla -----");
        System.out.println("1. Seleccionar un registro por su id");
        System.out.println("2. Ver todos los registros en la tabla ocupaciones");
        System.out.println("3. Regresar");
        System.out.println(">> Ingrese la opcion deseada <<");

        opcion = sn.nextInt();
        sn.nextLine();
        if (opcion == 1) {
            System.out.println("Porfavor ingrese el ID del registro deseado");
            id = sn.nextInt();
            sn.nextLine();
            ocupacion = (Ocupaciones) ocupacionesService.getByID(id);
            System.out.println("Registro encotrado: "+ ocupacion);
        } else if (opcion == 2) {
            System.out.println("------ Todos los registros ------");
            ocupacionesList = ocupacionesService.getAll();
            for (Ocupaciones ocupacionEncontrada: ocupacionesList){
                System.out.println("------- Registro con ID: "+ocupacionEncontrada.getId()+" -------");
                System.out.println(ocupacionEncontrada);
                System.out.println("---------------------------------\n");

            }
            mensajeMenu();
        } else if (opcion == 3) {
            mensajeMenu();
        }
    }
}
