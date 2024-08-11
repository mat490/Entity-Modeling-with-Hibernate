package edu.unam.proyecto.avance.view.impl;


import edu.unam.proyecto.avance.model.DatosPersonalesGenerales;
import edu.unam.proyecto.avance.model.Direccion;
import edu.unam.proyecto.avance.model.Sexo;
import edu.unam.proyecto.avance.service.GenericDAOService;
import edu.unam.proyecto.avance.service.impl.DatosPersonalesGeneralesServiceImpl;
import edu.unam.proyecto.avance.service.impl.DireccionServiceImpl;
import edu.unam.proyecto.avance.service.impl.PacientesServiceImpl;
import edu.unam.proyecto.avance.service.impl.SexoServiceImpl;
import edu.unam.proyecto.avance.view.Menu;
import edu.unam.proyecto.avance.view.TablesUI;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class DatosPersonalesMenuImpl implements TablesUI {
    private static DatosPersonalesMenuImpl instance;
    private static GenericDAOService datosPersonalesService = DatosPersonalesGeneralesServiceImpl.getInstance();
    private static GenericDAOService direccionService = DireccionServiceImpl.getInstance();
    private static GenericDAOService sexosService = SexoServiceImpl.getInstance();
    Menu menuPrincipal = MenuImpl.getInstance();
    Scanner sn;

    public static DatosPersonalesMenuImpl getInstance() {
        if (instance == null){
            instance = new DatosPersonalesMenuImpl();
        }
        return instance;
    }

    private DatosPersonalesMenuImpl(){}

    @Override
    public void mensajeMenu() {
        int opcion;
        System.out.println("######### Menu catálogo datos personales generales #########");
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
        String nombre;
        String nombre2;
        String apellido1;
        String apellido2;
        LocalDate fechaNacimiento;
        String telefono;
        String correoElectronico;
        Direccion direccion;
        Sexo sexo;
        DatosPersonalesGenerales nuevosDatosPersonalesGenerales = new DatosPersonalesGenerales();
        sn = new Scanner(System.in);
        int id;
        //
        System.out.println("----- Insertar un nuevo valor en tabla -----");
        System.out.println(">> Escriba el primer nombre << \n");
        nombre = sn.nextLine();
        nuevosDatosPersonalesGenerales.setNombre(nombre);
        //
        System.out.println(">> Escriba el segundo nombre << \n");
        nombre2 = sn.nextLine();
        nuevosDatosPersonalesGenerales.setNombre2(nombre2);
        //
        System.out.println(">> Escriba el primer apellido << \n");
        apellido1 = sn.nextLine();
        nuevosDatosPersonalesGenerales.setApellido1(apellido1);
        //
        System.out.println(">> Escriba el segundo apellido << \n");
        apellido2 = sn.nextLine();
        nuevosDatosPersonalesGenerales.setApellido2(apellido2);
        //
        System.out.println(">> Escriba la fecha de nacimiento (YYYY-MM-DD) << \n");
        String fechaString = sn.nextLine();
        fechaNacimiento = LocalDate.parse(fechaString);
        nuevosDatosPersonalesGenerales.setFechaNacimiento(fechaNacimiento);
        //
        System.out.println(">> Escriba el telefono << \n");
        telefono = sn.nextLine();
        nuevosDatosPersonalesGenerales.setTelefono(telefono);
        //
        System.out.println(">> Escriba el correo electrónico << \n");
        correoElectronico =  sn.nextLine();
        nuevosDatosPersonalesGenerales.setCorreoElectronico(correoElectronico);
        //
        System.out.println("*******Direcciones disponibles*******");
        List<Direccion> direccionList = direccionService.getAll();
        for (Direccion direccionEncontrada : direccionList){
            System.out.println("ID: "+direccionEncontrada.getId()+" \n"+direccionEncontrada);
        }
        System.out.println("**************************************");
        //
        System.out.println(">> Escriba el id de la dirección << \n");
        id = sn.nextInt();
        sn.nextLine();
        direccion = (Direccion) direccionService.getByID(id);
        nuevosDatosPersonalesGenerales.setDireccion(direccion);
        //
        System.out.println(">> Escriba id del sexo  << \n");
        id =  sn.nextInt();
        sn.nextLine();
        sexo = (Sexo) sexosService.getByID(id);
        nuevosDatosPersonalesGenerales.setSexo(sexo);
        //
        datosPersonalesService.insertEntity(nuevosDatosPersonalesGenerales);
        System.out.println(nuevosDatosPersonalesGenerales + " insertados cottectamente");
        mensajeMenu();

    }

    @Override
    public void updateEntradas() {
        String nombre;
        String nombre2;
        String apellido1;
        String apellido2;
        LocalDate fechaNacimiento;
        String telefono;
        String correoElectronico;
        Direccion direccion;
        Sexo sexo;
        DatosPersonalesGenerales nuevosDatosPersonalesGenerales = new DatosPersonalesGenerales();
        sn = new Scanner(System.in);
        int id;
        //
        System.out.println("----- Actualizar un nuevo valor en tabla -----");
        System.out.println(">> Escriba id del registro que desea actualizar << \n");
        id = sn.nextInt();
        nuevosDatosPersonalesGenerales.setId(id);
        //
        System.out.println(">> Escriba el primer nombre << \n");
        nombre = sn.nextLine();
        nuevosDatosPersonalesGenerales.setNombre(nombre);
        //
        System.out.println(">> Escriba el segundo nombre << \n");
        nombre2 = sn.nextLine();
        nuevosDatosPersonalesGenerales.setNombre2(nombre2);
        //
        System.out.println(">> Escriba el primer apellido << \n");
        apellido1 = sn.nextLine();
        nuevosDatosPersonalesGenerales.setApellido1(apellido1);
        //
        System.out.println(">> Escriba el segundo apellido << \n");
        apellido2 = sn.nextLine();
        nuevosDatosPersonalesGenerales.setApellido2(apellido2);
        //
        System.out.println(">> Escriba la fecha de nacimiento (YYYY-MM-DD) << \n");
        String fechaString = sn.nextLine();
        fechaNacimiento = LocalDate.parse(fechaString);
        nuevosDatosPersonalesGenerales.setFechaNacimiento(fechaNacimiento);
        //
        System.out.println(">> Escriba el telefono << \n");
        telefono = sn.nextLine();
        nuevosDatosPersonalesGenerales.setTelefono(telefono);
        //
        System.out.println(">> Escriba el correo electrónico << \n");
        correoElectronico =  sn.nextLine();
        nuevosDatosPersonalesGenerales.setCorreoElectronico(correoElectronico);
        //
        System.out.println("*******Direcciones disponibles*******");
        List<Direccion> direccionList = direccionService.getAll();
        for (Direccion direccionEncontrada : direccionList){
            System.out.println("ID: "+direccionEncontrada.getId()+" \n"+direccionEncontrada);
        }
        System.out.println("**************************************");
        //
        System.out.println(">> Escriba el id de la dirección << \n");
        id = sn.nextInt();
        sn.nextLine();
        direccion = (Direccion) direccionService.getByID(id);
        nuevosDatosPersonalesGenerales.setDireccion(direccion);
        //
        System.out.println("*******sexos disponibles*******");
        List<Sexo> sexoList = sexosService.getAll();
        for (Sexo sexoEncotnrado : sexoList){
            System.out.println(sexoEncotnrado);
        }
        System.out.println("*******************************");
        //
        System.out.println(">> Escriba id del sexo  << \n");
        id =  sn.nextInt();
        sn.nextLine();
        sexo = (Sexo) sexosService.getByID(id);
        nuevosDatosPersonalesGenerales.setSexo(sexo);
        //
        datosPersonalesService.insertEntity(nuevosDatosPersonalesGenerales);
        System.out.println(nuevosDatosPersonalesGenerales + " actualizados cottectamente");
        mensajeMenu();
    }

    @Override
    public void deleteEntradas() {
        sn = new Scanner(System.in);
        int id;
        System.out.println("----- Borrar un registro en tabla -----");
        System.out.println(">> Escriba id del registro que desea borrar << \n");
        id = sn.nextInt();
        //
        datosPersonalesService.delete(datosPersonalesService.getByID(id));
        System.out.println("Se borró correctamente");

        mensajeMenu();

    }

    @Override
    public void selectsEntradas() {
        int id;
        int opcion;
        DatosPersonalesGenerales datosPersonalesGenerales = new DatosPersonalesGenerales();
        List<DatosPersonalesGenerales> datosPersonalesGeneralesList;
        System.out.println("----- Ver registros en la tabla -----");
        System.out.println("1. Seleccionar un registro por su id");
        System.out.println("2. Ver todos los registros en la tabla");
        System.out.println("3. Regresar");
        System.out.println(">> Ingrese la opcion deseada <<");

        opcion = sn.nextInt();
        sn.nextLine();
        if (opcion == 1){
            System.out.println("Porfavor ingrese el ID del registro deseado");
            id = sn.nextInt();
            sn.nextLine();
            datosPersonalesGenerales = (DatosPersonalesGenerales) datosPersonalesService.getByID(id);
            System.out.println("Registro encontrado: \n"+datosPersonalesGenerales);
            mensajeMenu();

        } else if (opcion == 2) {
            System.out.println("------ Todos los registros ------");
            datosPersonalesGeneralesList = datosPersonalesService.getAll();
            for (DatosPersonalesGenerales datosPersonalesGeneralesEncontrado : datosPersonalesGeneralesList){
                System.out.println("------- Registro con ID: "+datosPersonalesGeneralesEncontrado.getId()+" -------");
                System.out.println(datosPersonalesGeneralesEncontrado);
                System.out.println("---------------------------------\n");
            }
            mensajeMenu();
        } else if(opcion == 3) {
            mensajeMenu();
        }

    }
}
