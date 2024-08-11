package edu.unam.proyecto.avance.view.impl;

import edu.unam.proyecto.avance.model.LugaresNacimiento;
import edu.unam.proyecto.avance.view.TablesUI;
import edu.unam.proyecto.avance.model.Direccion;
import edu.unam.proyecto.avance.service.GenericDAOService;
import edu.unam.proyecto.avance.service.impl.DireccionServiceImpl;

import java.util.List;
import java.util.Scanner;

public class DireccionesMenuImpl implements TablesUI {
    private static final GenericDAOService direccionService = DireccionServiceImpl.getInstance();
    Scanner sn;
    MenuImpl menuPrincipal = MenuImpl.getInstance();
    private static DireccionesMenuImpl instance;

    public static  DireccionesMenuImpl getInstance() {
        if (instance == null){
            instance = new DireccionesMenuImpl();
        }
        return instance;
    }

    private DireccionesMenuImpl(){

    }

    @Override
    public void mensajeMenu() {
        int opcion;
        System.out.println("######### Menu catálogo direcciones #########");
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
        Direccion nuevaDireccion = new Direccion();
        String direccion;
        int numeroCasa;
        System.out.println("----- Insertar un nuevo valor en tabla -----");
        System.out.println(">> Escriba el nombre de su país de residencia << \n");
        sn = new Scanner(System.in);
        direccion = sn.nextLine();
        nuevaDireccion.setPais(direccion);
        //
        System.out.println(">> Escriba el nombre de su estado de residencia << \n");
        direccion = sn.nextLine();
        nuevaDireccion.setEstado(direccion);
        //
        System.out.println(">> Escriba el nombre de su municipio de residencia << \n");
        direccion = sn.nextLine();
        nuevaDireccion.setMunicipio(direccion);
        //
        System.out.println(">> Escriba el nombre de su colonia de residencia << \n");
        direccion = sn.nextLine();
        nuevaDireccion.setColonia(direccion);
        //
        System.out.println(">> Escriba el nombre de su calle de residencia << \n");
        direccion = sn.nextLine();
        nuevaDireccion.setCalle(direccion);
        //
        System.out.println(">> Escriba el numero de su casa << \n");
        numeroCasa = sn.nextInt();
        nuevaDireccion.setNumeroCasa(numeroCasa);
        sn.nextLine();
        //
        System.out.println(">> Escriba su codigo postal << \n");
        direccion = sn.nextLine();
        nuevaDireccion.setCodigoPostal(direccion);
        //
        direccionService.insertEntity(nuevaDireccion);
        System.out.println(nuevaDireccion +" insertado correctamente");
        mensajeMenu();
    }

    @Override
    public void updateEntradas() {
        Direccion direccionActualizada = new Direccion();
        int id;
        int numeroCasa;
        String direccion;
        sn = new Scanner(System.in);
        //
        System.out.println("----- Actualizar un registro en tabla -----");
        System.out.println(">> Escriba el id de la dirección que desea actualizar << \n");
        id = sn.nextInt();
        sn.nextLine();
        //
        direccionActualizada.setId(id);
        System.out.println(">> Escriba el nombre de su estado de residencia << \n");
        direccion = sn.nextLine();
        direccionActualizada.setEstado(direccion);
        //
        System.out.println(">> Escriba el nombre de su municipio de residencia << \n");
        direccion = sn.nextLine();
        direccionActualizada.setMunicipio(direccion);
        //
        System.out.println(">> Escriba el nombre de su colonia de residencia << \n");
        direccion = sn.nextLine();
        direccionActualizada.setColonia(direccion);
        //
        System.out.println(">> Escriba el nombre de su calle de residencia << \n");
        direccion = sn.nextLine();
        direccionActualizada.setCalle(direccion);
        //
        System.out.println(">> Escriba el numero de su casa << \n");
        numeroCasa = sn.nextInt();
        direccionActualizada.setNumeroCasa(numeroCasa);
        sn.nextLine();
        //
        System.out.println(">> Escriba su codigo postal << \n");
        direccion = sn.nextLine();
        direccionActualizada.setCodigoPostal(direccion);
        //
        direccionService.insertEntity(direccionActualizada);
        System.out.println(direccionActualizada +" insertado correctamente");
        mensajeMenu();
    }

    @Override
    public void deleteEntradas() {
        int id;
        sn = new Scanner(System.in);
        //
        System.out.println("----- Borrar un registro en tabla -----");
        System.out.println(">> Escriba el id de la dirección que desea borrar <<");
        id = sn.nextInt();
        sn.nextLine();
        //
        direccionService.delete(direccionService.getByID(id));
        System.out.println("Se borró correctamente");
        mensajeMenu();
    }

    @Override
    public void selectsEntradas() {
        List<Direccion> listDirecciones;
        Direccion direccion;
        int opcion;
        int id;

        //
        System.out.println("----- Ver registros en la tabla -----");
        System.out.println("1. Seleccionar un registro por su id");
        System.out.println("2. Ver todos los registros en la tabla direcciones");
        System.out.println("3. Regresar");
        System.out.println(">> Ingrese la opcion deseada <<");
        //
        opcion = sn.nextInt();
        sn.nextLine();
        if (opcion == 1) {
            System.out.println("Porfavor ingrese el ID del registro deseado");
            id = sn.nextInt();
            sn.nextLine();
            direccion = (Direccion) direccionService.getByID(id);
            System.out.println("Registro encontrado: "+direccion);
            mensajeMenu();
        } else if (opcion == 2) {
            System.out.println("------ Todos los registros ------");

            listDirecciones = direccionService.getAll();
            for (Direccion direccionEncontrada : listDirecciones)

            {
                System.out.println("------- Registro con ID: "+direccionEncontrada.getId()+" -------");
                System.out.println(direccionEncontrada);
                System.out.println("---------------------------------\n");
            }
            mensajeMenu();
        } else if (opcion == 3) {
            mensajeMenu();
        }
    }
}
