package edu.unam.proyecto.avance.view.impl;

import edu.unam.proyecto.avance.model.Rh;
import edu.unam.proyecto.avance.service.GenericDAOService;
import edu.unam.proyecto.avance.service.impl.RhServiceImpl;
import edu.unam.proyecto.avance.view.Menu;
import edu.unam.proyecto.avance.view.TablesUI;

import java.util.List;
import java.util.Scanner;

public class RhMenuImpl implements TablesUI {
    private static RhMenuImpl instance;
    private static GenericDAOService rhService = RhServiceImpl.getInstance();
    Menu menuPrincipal = MenuImpl.getInstance();
    Scanner sn;

    public static RhMenuImpl getInstance() {
        if (instance == null ){
            instance = new RhMenuImpl();
        }
        return instance;
    }

    private RhMenuImpl (){}


    @Override
    public void mensajeMenu() {
        int opcion;
        System.out.println("######### Menu catálogo RH #########");
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
        String rh;
        Rh nuevoRh = new Rh();
        sn = new Scanner(System.in);
        System.out.println("----- Insertar un nuevo valor en tabla -----");
        System.out.println(">> Escriba el nombre del RH << \n");
        rh = sn.nextLine();
        nuevoRh.setRh(rh);
        rhService.insertEntity(nuevoRh);
        System.out.println(nuevoRh +" insertado correctamente");
        mensajeMenu();

    }

    @Override
    public void updateEntradas() {
        String rh;
        int id;
        Rh nuevoRh = new Rh();
        sn = new Scanner(System.in);
        System.out.println("----- Actualizar un registro en tabla -----");
        System.out.println(">> Escriba el id del RH que desea actualizar << \n");
        id = sn.nextInt();
        nuevoRh.setId(id);
        //
        System.out.println(">> Escriba el nuevo nombre del RH << \n");
        rh = sn.nextLine();
        nuevoRh.setRh(rh);
        rhService.insertEntity(nuevoRh);
        System.out.println(nuevoRh +" actualizado correctamente");
        mensajeMenu();
    }

    @Override
    public void deleteEntradas() {
        int id;
        System.out.println("----- Borrar un registro en tabla -----");
        System.out.println(">> Escriba el id del RH que desea borrar <<");
        id = sn.nextInt();
        sn.nextLine();
        //
        rhService.delete(rhService.getByID(id));
        System.out.println("Se borró correctamente");
        mensajeMenu();

    }

    @Override
    public void selectsEntradas() {
        List<Rh> rhList;
        Rh rh;
        int id;
        int opcion;

        System.out.println("----- Ver registros en la tabla -----");
        System.out.println("1. Seleccionar un registro por su id");
        System.out.println("2. Ver todos los registros en la tabla sexos");
        System.out.println("3. Regresar");
        System.out.println(">> Ingrese la opcion deseada <<");

        opcion = sn.nextInt();
        sn.nextLine();
        if (opcion == 1) {
            System.out.println("Porfavor ingrese el ID del registro deseado");
            id = sn.nextInt();
            sn.nextLine();
            rh = (Rh) rhService.getByID(id);
            System.out.println("Registro encontrado: "+rh);
            mensajeMenu();

        } else if (opcion==2) {
            System.out.println("------ Todos los registros ------");
            rhList = rhService.getAll();
            for (Rh rhEncontrado: rhList){
                System.out.println("------- Registro con ID: "+rhEncontrado.getId()+" -------");
                System.out.println(rhEncontrado);
                System.out.println("---------------------------------\n");
            }
            mensajeMenu();
        } else if (opcion == 3) {
            mensajeMenu();

        }


    }
}
