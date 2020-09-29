/*
 * Copyright (c) 26/9/2020.
 * created by Mateo Pinzon, Harrison Diaz y Juan Jose Ariza
 * All rights reserved
 */

package test;

import models.*;

import java.util.Scanner;
/**
 * Esta clase hace el testeo de la clase User
 * @Author Mateo Pinzon, Harrison Diaz y Juan Ariza
 * @Date 26/09/2020
 */
public class TestUser {

    Scanner scanner = new Scanner(System.in);
    Hotel hotel = new Hotel();
    Admin admin = new Admin(hotel);

    /**
     * Metodo que nos permite crear un usuario en la lista, usado como pruebas
     */
    public void add(){
        System.out.println("Ingrese el nombre ");
        String name = scanner.nextLine();
        System.out.println("Ingrese el numero de telefono");
        long phone = Long.parseLong(scanner.nextLine());
        System.out.println("Ingrese el id (nombre de usuario)");
        long id = Long.parseLong(scanner.nextLine());
        System.out.println("Ingrese una contraseña para el crear el usuario");
        String password = scanner.nextLine();
        hotel.addUser(new User(name,phone,id,password));
    }

    /**
     * Metodo que ayuda a hacer pruebas en un usuario
     */
    public void test() {
        System.out.println("1). Ingresar un nuevo usuario \n2). Mostrar la lista de usuarios que tiene el hotel\n3). Buscar un usuario dentro de la lista\n4).Verificar inicio de sesion de un usuario creado\n5).Terminar el programa");
        String option = scanner.nextLine();
        switch (option) {
            case "1":
                add();
                test();
                break;
            case "2":
                System.out.println("Los usuarios del Hotel son: ");
                String[] aux = admin.showUser();
                for (String s : aux) {
                    System.out.println(s);
                }
                test();
                break;
            case "3":
                System.out.println("Ingrese el id del ususario que desea buscar");
                long search = Long.parseLong(scanner.nextLine());
                System.out.println(admin.searchUser(search));
                test();
                break;
            case "4":
                System.out.println("Ingrese su ID");
                long id = Long.parseLong(scanner.nextLine());
                System.out.println("Ingrese su contraseña");
                String password = scanner.nextLine();
                System.out.println(hotel.verifyData(id, password));
                test();
                break;
            case "5":
                System.out.println("Vuelva pronto");
                break;
            default:
                System.out.println("Opcion no valida");
                test();
        }
    }

    public static void main(String[] args) {
      new TestUser().test();
    }
}
