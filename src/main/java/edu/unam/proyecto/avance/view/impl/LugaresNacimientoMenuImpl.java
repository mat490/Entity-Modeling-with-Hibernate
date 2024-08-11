package edu.unam.proyecto.avance.view.impl;

import edu.unam.proyecto.avance.model.LugaresNacimiento;
import edu.unam.proyecto.avance.service.GenericDAOService;
import edu.unam.proyecto.avance.service.impl.LugaresNacimientoServiceImpl;
import edu.unam.proyecto.avance.view.Menu;
import edu.unam.proyecto.avance.view.TablesUI;

import java.util.List;
import java.util.Scanner;

public class LugaresNacimientoMenuImpl implements TablesUI {
    private static LugaresNacimientoMenuImpl instance;
    private static GenericDAOService lugarNacimientoService = LugaresNacimientoServiceImpl.getInstance();

    Menu menuPrincipal = MenuImpl.getInstance();
    Scanner sn;

    public static LugaresNacimientoMenuImpl getInstance() {
        if (instance == null){
            instance = new LugaresNacimientoMenuImpl();
        }
        return instance;
    }

    private LugaresNacimientoMenuImpl(){

    }


    @Override
    public void mensajeMenu() {
        int opcion;
        System.out.println("######### Menu catálogo lugares de nacimiento #########");
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
        String pais;
        String estado;
        String municipio;
        LugaresNacimiento nuevoLugarNacimiento = new LugaresNacimiento();
        sn = new Scanner(System.in);
        System.out.println("----- Insertar un nuevo valor en tabla -----");
        System.out.println(">> Escriba el nombre del pais de nacimiento << \n");
        pais = sn.nextLine();
        nuevoLugarNacimiento.setPais(pais);
        //
        System.out.println(">> Escriba el nombre del estado de nacimiento << \n");
        estado = sn.nextLine();
        nuevoLugarNacimiento.setEstado(estado);
        //
        System.out.println(">> Escriba el nombre del municipio de nacimiento << \n");
        municipio = sn.nextLine();
        nuevoLugarNacimiento.setMunicipio(municipio);
        //
        lugarNacimientoService.insertEntity(nuevoLugarNacimiento);
        System.out.println(nuevoLugarNacimiento +" insertado correctamente");
        mensajeMenu();
    }

    @Override
    public void updateEntradas() {
        int id;
        String pais;
        String estado;
        String municipio;
        LugaresNacimiento nuevoLugarNacimiento = new LugaresNacimiento();
        sn = new Scanner(System.in);
        //
        System.out.println("----- Actualizar un registro en tabla -----");
        System.out.println(">> Escriba el id del sexo que desea actualizar << \n");
        id = sn.nextInt();
        sn.nextLine();
        nuevoLugarNacimiento.setId(id);
        //
        System.out.println(">> Escriba el nombre del pais de nacimiento << \n");
        pais = sn.nextLine();
        nuevoLugarNacimiento.setPais(pais);
        //
        System.out.println(">> Escriba el nombre del estado de nacimiento << \n");
        estado = sn.nextLine();
        nuevoLugarNacimiento.setEstado(estado);
        //
        System.out.println(">> Escriba el nombre del municipio de nacimiento << \n");
        municipio = sn.nextLine();
        nuevoLugarNacimiento.setMunicipio(municipio);

        lugarNacimientoService.insertEntity(nuevoLugarNacimiento);
        System.out.println(nuevoLugarNacimiento+" se insertó correctament");
    }

    @Override
    public void deleteEntradas() {
        int id;
        sn = new Scanner(System.in);
        System.out.println("----- Borrar un registro en tabla -----");
        System.out.println(">> Escriba el id del lugar de nacimiento que desea borrar <<");
        id = sn.nextInt();
        sn.nextLine();
        //
        lugarNacimientoService.delete(lugarNacimientoService.getByID(id));
        //
        System.out.println("Se borró correctamente");
        mensajeMenu();

    }

    @Override
    public void selectsEntradas() {
        List<LugaresNacimiento> lugaresNacimientoList;
        int id;
        int opcion;
        LugaresNacimiento lugarNacimiento = new LugaresNacimiento();
        System.out.println("----- Ver registros en la tabla -----");
        System.out.println("1. Seleccionar un registro por su id");
        System.out.println("2. Ver todos los registros en la tabla lugares de nacimiento");
        System.out.println("3. Regresar");
        System.out.println(">> Ingrese la opcion deseada <<");

        opcion = sn.nextInt();
        sn.nextLine();
        if (opcion == 1) {
            System.out.println("Porfavor ingrese el ID del registro deseado");
            id = sn.nextInt();
            sn.nextLine();
            lugarNacimiento = (LugaresNacimiento) lugarNacimientoService.getByID(id);
            System.out.println("Registro encontrado: "+lugarNacimiento);
            mensajeMenu();
        } else if (opcion==2){
            System.out.println("------ Todos los registros ------");
            lugaresNacimientoList = lugarNacimientoService.getAll();
            for (LugaresNacimiento lugarNacimientoEncontrada : lugaresNacimientoList){
                System.out.println("------- Registro con ID: "+lugarNacimientoEncontrada.getId()+" -------");
                System.out.println(lugarNacimientoEncontrada);
                System.out.println("---------------------------------\n");
            }
            mensajeMenu();

        } else if (opcion==3) {
            mensajeMenu();
        }
    }
}
