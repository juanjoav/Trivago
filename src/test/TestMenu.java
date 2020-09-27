/*
 * Copyright (c) 26/9/2020.
 * created by Mateo Pinzon, Harrison Diaz y Juan Jose Ariza
 * All rights reserved
 */

package test;


import models.Admin;
import models.Hotel;
import models.Menu;
import java.util.Scanner;

public class TestMenu {

        Hotel hotel = new Hotel();
        Admin admin = new Admin(hotel);
        Scanner scanner = new Scanner(System.in);

    /**
     *Metodo con recursividad para hacer llamados de pruebas
     */
    public void add(){
        System.out.println("Ingrese el nombre del menu");
        String menuName = scanner.nextLine();
        System.out.println("Ingrese (en una sola linea) los platos que desea tener en el nuevo menu del dia");
        String menuCharacteristics = scanner.nextLine();
        System.out.println("Ingrese el precio que va a tener el nuevo menu");
        double menuPrice = Double.parseDouble(scanner.nextLine());
        admin.addMenu(new Menu(menuName,menuCharacteristics,menuPrice));
    }

    /**
     * Metodo que testea la clase menu
     */
    public void test() {
        System.out.println("1). Ingresar un nuevos menu \n2). Mostrar los menus con sus respectivo precio\n3). Eliminar un menu por nombre (si no se encuentra el nombre del menu no sera eliminado)\n4).Modificar un menu\n5).Terminar el programa");
        String option = scanner.nextLine();
        switch (option) {
            case "1":
                add();
                test();
                break;
            case "2":
                System.out.println("Los menus del dia son: ");
                String[] aux = hotel.viewMenus();
                for (String s : aux) {
                    System.out.println(s);
                }
                test();
                break;
            case "3":
                System.out.println("Ingrese el nombre menu que desea eliminar");
                String menuNameRemove = scanner.nextLine();
                admin.removeMenu(menuNameRemove);
                test();
                break;
            case "4":
                System.out.println("Ingrese el nombre menu que desea Modificar");
                String menuNameChange = scanner.nextLine();
                admin.removeMenu(menuNameChange);
                add();
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

        public static void main (String[]args){
            new TestMenu().test();
        }
}
