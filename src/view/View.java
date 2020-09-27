/*
 * Copyright (c) 27/9/2020.
 * created by Mateo Pinzon, Harrison Diaz y Juan Jose Ariza
 * All rights reserved
 */

package view;

import java.util.Scanner;

public class View {

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

    private Scanner scanner;

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
        System.out.println("Por favor ingrese el nombre del usuario: ");
        return scanner.nextLine();
    }

    /**
     * Permite enviar la contraseña respectiva
     * @return
     */
    public String passaword(){
        System.out.println(LINE);
        System.out.println("Por favor ingrese su contraseña: ");
        System.out.println(LINE);
        return scanner.nextLine();
    }

    /**
     * permite enviar la seleccion de opciones del admin
     * @return
     */
    public int adminOption(){
        System.out.println("----------------------Menu del Administrador-------------------------");
        System.out.println("1.)Agregar menus");
        System.out.println("2.)Agregar un nuevo usuario");
        System.out.println("3.)Mostrar la lista de usuarios");
        return Integer.parseInt(scanner.nextLine());
    }

    /////////////////////////////MENUS/////////////////////////////////////////////////

    /**
     * permite enviar el nombre del menu que desea agregar
     * @return
     */
    public String menuName(){

        System.out.println("Por favor ingrese el tipo de menu que desea agregar: ");
        return scanner.nextLine();
    }

    /**
     * envia los datos que contiene cada menu
     * @return
     */
    public String menuContains(){
        System.out.println("Por agregue los elementos del menu (separados por comas): ");
        return scanner.nextLine();
    }

    /**
     * envia los datos del precio de cada menu
     * @return
     */
    public double menuPrice(){
        System.out.println("Agregue el valor del menu: ");
        return Double.parseDouble(scanner.nextLine());
    }
    /////////////////////////////////////////////////////USER//////////////////////////////////////////////////////////////

    /**
     * Metodo que permite elejir una opcion por parte del usuario
     * @return la opcion elejida por el usuario
     */
    public int userMenu(){
        System.out.println("Opciones de usuario");
        System.out.println("1.) Ingresar \n2.) Iniciar secion\n 3.) regresar");
        return Integer.parseInt(scanner.nextLine());
    }

    /**
     *
     * @return el id del usuario
     */
    public long getId(){
        System.out.println("Ingrese el ID de usuario");
        return Long.parseLong(scanner.nextLine());
    }

    /**
     * envia el telefono del usuario
     * @return
     */
    public long getphone(){
        System.out.println("Ingrese el telefono del usuario");
        return Long.parseLong(scanner.nextLine());
    }

    public String getPassaword(){
        System.out.println("Por favor ingrese su contraseña");
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
     * recibe Elementos para mostrar al admin y/o usuarios
     * @param message
     */
    public void viewMessages(String message){
        System.out.println( message);
    }

    public void viewList(String [] lists){
        for (String string:lists) {
            System.out.println(string);
        }
    }
}
