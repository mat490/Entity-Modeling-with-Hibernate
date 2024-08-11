package edu.unam.proyecto.avance.view.impl;


import edu.unam.proyecto.avance.view.Menu;
import edu.unam.proyecto.avance.view.TablesUI;


import java.util.Scanner;


public class MenuImpl implements Menu {
    private static MenuImpl instance;

    public static MenuImpl getInstance() {
        if (instance == null)
            instance = new MenuImpl();
        return instance;
    }

    private  MenuImpl (){


    }

    @Override
    public void menuMessage(){
        Scanner sn = new Scanner(System.in);
        int opcion;

        System.out.println("########### Bienvenido a la entrega final del modulo 4 ###########");

        System.out.println("----- ¿Sobre que catálogo desea trabajar? ------");
        System.out.println("1. Pacientes."  + "\n" + "2. Sexo" + "\n" + "3. Datos Personales Generales." + "\n"+
                "4. Estados Civiles." + "\n" + "5. Direcciones." + "\n" + "6. COMBE." + "\n" + "7. Grupo Sanguineo." + "\n" +
                "8. Rh." + "\n" + "9. Lugares de Nacimiento." + "\n" + "10. Ocupaciones." +"\n"+ "11. Salir.");

        System.out.println(">>>>>> Ingrese el indice del catálogo <<<<<");
        opcion = sn.nextInt();
        mainMenuOptions(opcion);
    }

    private void mainMenuOptions(int opcion){
        switch (opcion){
            case 1:
                menuPacientes();
                break;
            case 2:
                menuSexo();
                break;
            case 3:
                menuDatosPersonales();
                break;
            case 4:
                menuEstadosCiviles();
                break;
            case 5:
                menuDirecciones();
                break;
            case 6:
                menuCombe();
                break;
            case 7:
                menuGruposSanguineos();
                break;
            case 8:
                menuRh();
                break;
            case 9:
                menuLugaresNacimiento();
                break;
            case 10:
                menuOcupaciones();
                break;
            case 11:
                break;
            default:
                break;
    }
    }


    @Override
    public void menuPacientes() {
        TablesUI pacientesMenu = PacientesMenuImpl.getInstance();
        pacientesMenu.mensajeMenu();
    }

    @Override
    public void menuDirecciones() {
        TablesUI menuDirecciones = DireccionesMenuImpl.getInstance();
         menuDirecciones.mensajeMenu();
    }

    @Override
    public void menuSexo() {
        TablesUI menuSexo =  SexoMenuImpl.getInstance();
         menuSexo.mensajeMenu();
    }

    @Override
    public void menuDatosPersonales() {
        TablesUI datosPersonalesMenu = DatosPersonalesMenuImpl.getInstance();
        datosPersonalesMenu.mensajeMenu();
    }

    @Override
    public void menuEstadosCiviles() {
        TablesUI estadoCivilMenu = EstadosCivilesMenuImpl.getInstance();
        estadoCivilMenu.mensajeMenu();

    }

    @Override
    public void menuCombe() {
        TablesUI combeMenu = CombeMenuImpl.getInstance();
        combeMenu.mensajeMenu();
    }

    @Override
    public void menuGruposSanguineos() {
        TablesUI grupoSanguineoMenu = GruposSanguineosMenuImpl.getInstance();
        grupoSanguineoMenu.mensajeMenu();
    }

    @Override
    public void menuRh() {
        TablesUI rhMenu = RhMenuImpl.getInstance();
        rhMenu.mensajeMenu();
    }

    @Override
    public void menuLugaresNacimiento() {
        TablesUI lugaresNacimientoMenu = LugaresNacimientoMenuImpl.getInstance();
        lugaresNacimientoMenu.mensajeMenu();
    }

    @Override
    public void menuOcupaciones() {
        TablesUI menuOcupaciones = OcupacionesMenuImpl.getInstance();
        menuOcupaciones.mensajeMenu();
    }
}
