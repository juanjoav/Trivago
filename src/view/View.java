/*
 * Copyright (c) 27/9/2020.
 * created by Mateo Pinzon, Harrison Diaz y Juan Jose Ariza
 * All rights reserved
 */

package view;

import java.util.Scanner;

public class View {

    private Scanner scanner;

    public static final int MENU_OPTION_ONE = 1;
    public static final int MENU_OPTION_TWO = 2;
    public static final int MENU_OPTION_TRHEE = 3;
    public static final int MENU_OPTION_FOUR = 4;
    public static final int MENU_OPTION_FIVE = 5;
    public static final int MENU_OPTION_SIX = 6;
    public static final int MENU_OPTION_SEVEN = 7;

    public static final String MESSAGE_FORMAR_EX = "PARAMETROS INVALIDOS";
    public static final String WELCOME_ASCCI = "°·.¸.·°¯°·.¸.·°¯°·.¸.-> ░S░i░s░t░e░m░a░ ░H░o░t░e░l░e░r░o░ <-·.¸.·°¯°·.¸.·°¯°·.¸.°";
    public static final String LINE = "-------------------------------------------";
    public static final String SELECTION_MENU = "Por favor elija el tipo de acceso que desea al sitema\n1). Administrador\n2).Usuarios ";
    public static final String REQUEST_NAME = "Por favor ingrese el nombre del usuario: ";
    public static final String REQUEST_PASSWORD = "Por favor ingrese una contraseña: ";
    public static final String TITTLE_ADMIN = "MENU DEL ADMINISTRADOR";
    public static final String TITTLE_USER = "MENU DEL USUARIO";
    public static final String NAME_MENU = "Por favor ingrese el tipo de menu que desea agregar: ";
    public static final String REMOVE_MENU = "Por favor ingrese el nombre del menu que desea eliminar:";
    public static final String CONTAINS_MENU = "Por favor en una sola linea agregue los elementos que va a tener el menu del dia: ";
    public static final String PRICE_MENU = "Agregue el precio que tendra el menu: ";
    public static final String OPTIONS_USER = "1.) Registrarse \n2.) Iniciar secion\n 3.) Regresar";
    public static final String USER_ID = "Ingrese el ID de usuario";
    public static final String USER_PHONE = "Ingrese el telefono del usuario";
    public static final String USER_PASSWORD = "Por favor ingrese su contraseña";


    public View() {
        scanner = new Scanner(System.in);
    }

    /**
     * Menu de opciones para elegir usuarios
     * @return
     */
    public int selectionMenu(){
        System.out.println(WELCOME_ASCCI);
        System.out.println(LINE);
        System.out.println(SELECTION_MENU);
        System.out.println(LINE);
        return Integer.parseInt(scanner.nextLine());
    }

    /**
     * Permite enviar el nickName de usuario y/o admin
     * @return
     */
    public String nickName(){
        System.out.println(LINE);
        System.out.println(REQUEST_NAME);
        System.out.println(LINE);
        return scanner.nextLine();
    }

    /**
     * Permite enviar la contraseña respectiva
     * @return
     */
    public String password(){
        System.out.println(LINE);
        System.out.println(REQUEST_PASSWORD);
        System.out.println(LINE);
        return scanner.nextLine();
    }
///////////////////////////ADMINS//////////////////////////////////////////

    /**
     * permite enviar la seleccion de opciones del admin
     * @return
     */
    public int adminOption(){
        System.out.println(LINE + TITTLE_ADMIN + LINE);
//        System.out.println("1).Agregar menus de comida\n2).Agregar un nuevo usuario\n3.)Mostrar lista de usuarior");//mirar con el controller
//        System.out.println("2.)Agregar un nuevo usuario");
//        System.out.println("3.)Mostrar la lista de usuarios");
        System.out.println("1.) Administrar menus\n 2.) Administrar usuarios \n 3.) Administrar habitaciones");
        return Integer.parseInt(scanner.nextLine());
    }

    /**
     * Metodo que permite el ingreso de una de las opciones que dispone el usuario sobre la clase menu
     * @return
     */
    public int adminMenuOption(){
        System.out.println("1.) Agregar menu\n2.)Retirar un menu\n3.)Modificar un menu\n4.)Mostrar menus\n5.) Para volver");
        return Integer.parseInt(scanner.nextLine());
    }

    public int adminUserMenu(){
        System.out.println("1.) Agregar un usuario\n 2.) Ver lista de usuarios\n 3.) Buscar un usuario\n4.) Para volver");
        return Integer.parseInt(scanner.nextLine());
    }

    public int adminUserRoom(){

        return Integer.parseInt(scanner.nextLine());
    }
    /////////////////////////////MENUS/////////////////////////////////////////////////

    /**
     * permite enviar el nombre del menu que desea agregar
     * @return
     */
    public String menuName(){
        System.out.println(NAME_MENU);
        return scanner.nextLine();
    }

    /**
     * Metodo que nso permite recibiel el tipo de menu que desea eliminar
     * @return un scanner para recibir el valor
     */
    public String deleteMenu(){
        System.out.println(REMOVE_MENU);
        return scanner.nextLine();
    }

    /**
     * envia los datos que contiene cada menu
     * @return
     */
    public String menuContains(){
        System.out.println(CONTAINS_MENU);
        return scanner.nextLine();
    }

    /**
     * envia los datos del precio de cada menu
     * @return
     */
    public double menuPrice(){
        System.out.println(PRICE_MENU);
        return Double.parseDouble(scanner.nextLine());
    }
    /////////////////////////////////////////////////////USER//////////////////////////////////////////////////////////////

    /**
     * Metodo que permite elejir una opcion por parte del usuario
     * @return la opcion elejida por el usuario
     */
    public int userMenu(){
        System.out.println(LINE + TITTLE_USER + LINE);
        System.out.println(OPTIONS_USER);
        return Integer.parseInt(scanner.nextLine());
    }

    /**
     *
     * @return el id del usuario
     */
    public long getId(){
        System.out.println(USER_ID);
        return Long.parseLong(scanner.nextLine());
    }

    /**
     * envia el telefono del usuario
     * @return
     */
    public long getphone(){
        System.out.println(USER_PHONE);
        return Long.parseLong(scanner.nextLine());
    }

    public String getPassaword(){
        System.out.println(USER_PASSWORD);
        return scanner.nextLine();
    }

/**
 //    public String getCashEvent(){
 //        System.out.println("Agregar la forma de pago");
 //        System.out.println("1.) EFECTIVO \n2.) TARJETA \n3.) VIRTUAL");
 //        return (scanner.nextLine());
 //    }
 //                                                                                  //revision pendiente para la eliminacion
 //    public String entryCondition(){
 //        System.out.println("Agregar la forma de registro");
 //        System.out.println("1.) WALKING \n 2.) BOOKING");
 //        return scanner.nextLine();
 //    }
 */


    /////////////////////////////////////////////////////RETORNOS//////////////////////////////////////////////////////////

    /**
     * Metodo que recibe Elementos para mostrar al admin y/o usuarios
     * @param message el parametro que desea mostrar
     */
    public void viewMessages(String message){
        System.out.println( message);
    }

    /**
     * Metodod que recibe una lista de elementos para mostrar
     * @param lists la lista que desea mostrar
     */
    public void viewList(String [] lists){
        for (String string:lists) {
            System.out.println(string);
        }
    }
}
