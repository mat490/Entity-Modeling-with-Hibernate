package edu.unam.proyecto.avance.view.impl;

import edu.unam.proyecto.avance.model.GruposSanguineos;
import edu.unam.proyecto.avance.service.GenericDAOService;
import edu.unam.proyecto.avance.service.impl.GruposSanguineosServiceImpl;
import edu.unam.proyecto.avance.view.Menu;
import edu.unam.proyecto.avance.view.TablesUI;

import java.util.List;
import java.util.Scanner;

public class GruposSanguineosMenuImpl implements TablesUI {
    private static GruposSanguineosMenuImpl instance;
    private static final GenericDAOService grupoSanguineoService = GruposSanguineosServiceImpl.getInstance();
    Scanner sn;
    Menu menuPrincipal = MenuImpl.getInstance();

    public static GruposSanguineosMenuImpl getInstance() {
        if (instance == null)
        {
            instance = new GruposSanguineosMenuImpl();
        }
        return instance;
    }

    private GruposSanguineosMenuImpl (){}

    @Override
    public void mensajeMenu() {
        int opcion;
        System.out.println("######### Menu catálogo de los grupos sanguineos #########");
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
        String grupoSanguineo;
        GruposSanguineos nuevoGrupoSanguineo = new GruposSanguineos();
        sn = new Scanner(System.in);
        System.out.println("----- Insertar un nuevo valor en tabla -----");
        System.out.println(">> Escriba el nombre del grupo sanguineo << \n");
        grupoSanguineo = sn.nextLine();
        nuevoGrupoSanguineo.setGrupoSanguineo(grupoSanguineo);
        //
        grupoSanguineoService.insertEntity(nuevoGrupoSanguineo);
        System.out.println(nuevoGrupoSanguineo.getGrupoSanguineo() +" insertado correctamente");
        mensajeMenu();
    }

    @Override
    public void updateEntradas() {
        String grupoSanguineo;
        GruposSanguineos nuevoGrupoSanguineo = new GruposSanguineos();
        Integer id;
        sn = new Scanner(System.in);
        System.out.println("----- Actualizar un registro en tabla -----");
        System.out.println(">> Escriba el id del grupo sanguineo que desea actualizar << \n");
        id = sn.nextInt();
        sn.nextLine();
        nuevoGrupoSanguineo.setId(id);
        //
        System.out.println(">> Escriba el nombre del grupo sanguineo << \n");
        grupoSanguineo = sn.nextLine();
        nuevoGrupoSanguineo.setGrupoSanguineo(grupoSanguineo);
        //
        grupoSanguineoService.updateEntity(nuevoGrupoSanguineo);
        System.out.println(nuevoGrupoSanguineo.getGrupoSanguineo() +" actualizado correctamente");
        mensajeMenu();

    }

    @Override
    public void deleteEntradas() {
        Integer id;
        //
        System.out.println("----- Borrar un registro en tabla -----");
        System.out.println(">> Escriba el id del grupo sanguineo que desea borrar <<");
        id = sn.nextInt();
        sn.nextLine();
        //
        grupoSanguineoService.delete(grupoSanguineoService.getByID(id));
        System.out.println("Se borró correctamente");
        mensajeMenu();

    }

    @Override
    public void selectsEntradas() {
        List<GruposSanguineos> gruposSanguineosList;
        GruposSanguineos grupoSanguineo;
        int opcion;
        int id;

        System.out.println("----- Ver registros en la tabla -----");
        System.out.println("1. Seleccionar un registro por su id");
        System.out.println("2. Ver todos los registros en la tabla grupos sanguineos");
        System.out.println("3. Regresar");
        System.out.println(">> Ingrese la opcion deseada <<");

        opcion = sn.nextInt();
        sn.nextLine();

        if (opcion == 1){
            System.out.println("Porfavor ingrese el ID del registro deseado");
            id = sn.nextInt();
            sn.nextLine();
            grupoSanguineo = (GruposSanguineos) grupoSanguineoService.getByID(id);
            System.out.println("Registro encontrado: " + grupoSanguineo.getGrupoSanguineo());
            mensajeMenu();
        } else if (opcion == 2) {
            System.out.println("------ Todos los registros ------");
            gruposSanguineosList = grupoSanguineoService.getAll();
            for (GruposSanguineos grupoSanguineoEncontrado : gruposSanguineosList){
                System.out.println("------- Registro con ID: "+grupoSanguineoEncontrado.getId()+" -------");
                System.out.println(grupoSanguineoEncontrado.getGrupoSanguineo());
                System.out.println("---------------------------------\n");
            }
            mensajeMenu();

        } else if (opcion == 3) {
            mensajeMenu();

        }
    }
}
