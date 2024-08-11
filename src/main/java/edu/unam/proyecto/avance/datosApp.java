package edu.unam.proyecto.avance;

import edu.unam.proyecto.avance.view.Menu;
import edu.unam.proyecto.avance.view.impl.MenuImpl;
import edu.unam.proyecto.avance.hibernate.HibernateUtil;


public class datosApp {

    public static void main(String[] args) {
        HibernateUtil.init();

        Menu mainMenu = MenuImpl.getInstance();
        mainMenu.menuMessage();

    }
}