package edu.unam.proyecto.avance.view.impl;

import edu.unam.proyecto.avance.view.Menu;
import edu.unam.proyecto.avance.view.TablesUI;
import edu.unam.proyecto.avance.model.Sexo;
import edu.unam.proyecto.avance.service.GenericDAOService;
import edu.unam.proyecto.avance.service.impl.SexoServiceImpl;

import java.util.List;
import java.util.Scanner;


public class SexoMenuImpl implements TablesUI {
    private static final GenericDAOService sexoDAOService = SexoServiceImpl.getInstance();
    Scanner sn;
    Menu menuPrincipal = MenuImpl.getInstance();
    private static SexoMenuImpl instance;

    public static  SexoMenuImpl getInstance() {
        if (instance == null){
            instance = new SexoMenuImpl();
        }
        return instance;
    }

    private SexoMenuImpl(){
    }

    public void mensajeMenu(){
        int opcion;
        System.out.println("######### Menu catálogo sexos #########");
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
        Sexo nuevoSexo = new Sexo();
        String sexo;
        sn = new Scanner(System.in);
        System.out.println("----- Insertar un nuevo valor en tabla -----");
        System.out.println(">> Escriba el nombre del sexo << \n");
        sexo = sn.nextLine();
        nuevoSexo.setSexo(sexo);
        sexoDAOService.insertEntity(nuevoSexo);
        System.out.println(nuevoSexo.getSexo() +" insertado correctamente");
        mensajeMenu();

    }

    @Override
    public void updateEntradas() {
        Sexo nuevoSexo = new Sexo();
        String sexo;
        Integer id;
        sn = new Scanner(System.in);
        System.out.println("----- Actualizar un registro en tabla -----");

        System.out.println(">> Escriba el id del sexo que desea actualizar << \n");
        id = sn.nextInt();
        sn.nextLine();
        nuevoSexo.setId(id);

        System.out.println(">> Escriba el sexo nuevo << \n");
        sexo = sn.nextLine();
        nuevoSexo.setSexo(sexo);
        sexoDAOService.updateEntity(nuevoSexo);
        System.out.println(nuevoSexo.getSexo() +" actualizado correctamente");
        mensajeMenu();

    }

    @Override
    public void deleteEntradas() {
        Integer id;
        sn = new Scanner(System.in);
        System.out.println("----- Borrar un registro en tabla -----");
        System.out.println(">> Escriba el id del sexo que desea borrar <<");
        id = sn.nextInt();
        sn.nextLine();
        //
        sexoDAOService.delete(sexoDAOService.getByID(id));
        System.out.println("Se borró correctamente");
        mensajeMenu();
    }

    @Override
    public void selectsEntradas() {
        List<Sexo> listSexos;
        Sexo sexo;
        int opcion;
        Integer id;


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
            sexo = (Sexo) sexoDAOService.getByID(id);
            System.out.println("Registro encontrado: "+sexo);
            mensajeMenu();
        } else if (opcion == 2) {
            System.out.println("------ Todos los registros ------");

            listSexos = sexoDAOService.getAll();
            for (Sexo sexoEncontrado: listSexos)
            {
                System.out.println("------- Registro con ID: "+sexoEncontrado.getId()+" -------");
                System.out.println(sexoEncontrado);
                System.out.println("---------------------------------\n");
            }
            mensajeMenu();
        } else if (opcion == 3) {
            mensajeMenu();
        }
    }
}
