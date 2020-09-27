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

    private Scanner scanner;

    public View() {
        scanner = new Scanner(System.in);
    }

    public int selectionMenu(){
        System.out.println("-------------------------------------------");
        System.out.println("Por favor elija el tipo de acceso que desea al sitema");
        System.out.println("1.) Administrador");
        System.out.println("2.) Usuarios");
        System.out.println("-------------------------------------------");
        return Integer.parseInt(scanner.nextLine());
    }

    public String nickName(){
        System.out.println("-------------------------------------------");
        System.out.println("Por favor ingrese el nombre del usuario: ");
        return scanner.nextLine();
    }

    public String passaword(){
        System.out.println("-------------------------------------------");
        System.out.println("Por favor ingrese su contraseña: ");
        System.out.println("-------------------------------------------");
        return scanner.nextLine();
    }

    public int adminOption(){
        System.out.println("----------------------Menu del Administrador-------------------------");
        System.out.println("1.)Agregar menus");
        return Integer.parseInt(scanner.nextLine());
    }
    /////////////////////////////MENUS/////////////////////////////////////////////////

    public String menuName(){
        System.out.println("Por favor ingrese el tipo de menu que desea agregar: ");
        return scanner.nextLine();
    }

    public String menuContains(){
        System.out.println("Por agregue los elementos del menu (separados por comas): ");
        return scanner.nextLine();
    }

    public double menuPrice(){
        System.out.println("Agregue el valor del menu: ");
        return Double.parseDouble(scanner.nextLine());
    }


    /////////////////////////////////////////////////////RETORNOS//////////////////////////////////////////////////////////

    public void viewMessages(String message){
        System.out.println( message);
    }
}
