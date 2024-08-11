package edu.unam.proyecto.avance.view.impl;

import edu.unam.proyecto.avance.model.Combe;
import edu.unam.proyecto.avance.service.GenericDAOService;
import edu.unam.proyecto.avance.service.impl.CombeServiceImpl;
import edu.unam.proyecto.avance.view.Menu;
import edu.unam.proyecto.avance.view.TablesUI;

import java.util.List;
import java.util.Scanner;

public class CombeMenuImpl implements TablesUI {
    private static CombeMenuImpl instance;
    private static GenericDAOService combeService = CombeServiceImpl.getInstance();
    Menu menuPrincipal = MenuImpl.getInstance();
    Scanner sn = new Scanner(System.in);

    public static CombeMenuImpl getInstance() {
        if (instance == null) {
            instance = new CombeMenuImpl();
        }
        return instance;
    }

    private CombeMenuImpl (){}

    @Override
    public void mensajeMenu() {
        int opcion;
        System.out.println("######### Menu catálogo COMBE #########");
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
        String combe;
        Combe nuevoCombe = new Combe();
        sn = new Scanner(System.in);
        System.out.println("----- Insertar un nuevo valor en tabla -----");
        System.out.println(">> Escriba el resultado del COMBE << \n");
        combe = sn.nextLine();
        nuevoCombe.setCombe(combe);
        combeService.insertEntity(nuevoCombe);
        System.out.println(nuevoCombe.getCombe() +" insertado correctamente");
        mensajeMenu();
    }

    @Override
    public void updateEntradas() {
        String combe;
        Combe nuevoCombe = new Combe();
        sn = new Scanner(System.in);
        int id;
        System.out.println("----- Insertar un nuevo valor en tabla -----");
        System.out.println(">> Escriba el ID del COMBE que desea cambiar << \n");
        id = sn.nextInt();
        sn.nextLine();
        nuevoCombe.setId(id);

        System.out.println(">> Escriba el nuevo resultado del COMBE << \n");
        combe = sn.nextLine();
        nuevoCombe.setCombe(combe);
        combeService.updateEntity(nuevoCombe);
        System.out.println(nuevoCombe.getCombe() +" actualizado correctamente");
        mensajeMenu();

    }

    @Override
    public void deleteEntradas() {
        int id;
        sn = new Scanner(System.in);
        System.out.println("----- Borrar un registro en tabla -----");
        System.out.println(">> Escriba el id del COMBE que desea borrar <<");
        id = sn.nextInt();
        combeService.delete(combeService.getByID(id));
        //
        System.out.println("borrado correctamente");
        mensajeMenu();
    }

    @Override
    public void selectsEntradas() {
        List<Combe> combeList;
        Combe combe;
        int opcion;
        int id;

        System.out.println("----- Ver registros en la tabla -----");
        System.out.println("1. Seleccionar un registro por su id");
        System.out.println("2. Ver todos los registros en la tabla sexos");
        System.out.println("3. Regresar");
        System.out.println(">> Ingrese la opcion deseada <<");

        opcion = sn.nextInt();
        sn.nextLine();
        if (opcion == 1){
            System.out.println("Porfavor ingrese el ID del registro deseado");
            id = sn.nextInt();
            sn.nextLine();
            combe = (Combe) combeService.getByID(id);
            System.out.println("Registro encontrado: "+combe.getCombe());
            mensajeMenu();
        } else if (opcion == 2) {
            System.out.println("------ Todos los registros ------");
            combeList = combeService.getAll();

            for (Combe combeEncontrado : combeList){
                System.out.println("------- Registro con ID: "+combeEncontrado.getId()+" -------");
                System.out.println(combeEncontrado.getCombe());
                System.out.println("---------------------------------\n");
            }
            mensajeMenu();
        } else if (opcion == 3) {
            mensajeMenu();

        }
    }
}
