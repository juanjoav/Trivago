/*
 * Copyright (c) 26/9/2020.
 * created by Mateo Pinzon, Harrison Diaz y Juan Jose Ariza
 * All rights reserved
 */

package test;


import models.Admin;
import models.Hotel;
import models.Menu;

import java.util.Arrays;
import java.util.Scanner;

public class TestMenu {

    /**
     * Metodo que testea la clase menu
     */

    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        Admin admin = new Admin(hotel);

        admin.addMenu(new Menu("","Carne, Pollo, arroz , papa. mondongo",8));
        admin.addMenu(new Menu("Vegetariano","Hierbas, mastas, cosas verdes ",12));
        admin.addMenu(new Menu("Epecial","Oro, mas pendejadas, ensalada de frutas",15));
        String[] aux = hotel.viewMenus();
        for (String s: aux) {
            System.out.println(s);
        }
//        System.out.println(Arrays.toString(hotel.viewMenus()));
//        admin.removeMenu("normal");
//        System.out.println(Arrays.toString(hotel.viewMenus()));

    }

//    public void test(){
//        System.out.println("1). Ingresar los nuevos menus \n2). Darles precio a cada menu\n3).Ver los precios y los valores de cada menu\n4).Modificar cada uno delos menu  ");
//        Scanner scanner = new Scanner(System.in);
//        int option = Integer.parseInt(scanner.nextLine());
//        switch (option){
//            case 1:
//                System.out.println("Ingrese los platos que desea tener en el menu normal del dia");
//                String[] menuNormal = scanner.nextLine().split(" ");
//                menu.addMenuNormal(menuNormal);
//                System.out.println("Ingrese los platos que desea tener en el menu vegano del dia");
//                String[] menuVegan = scanner.nextLine().split(" ");
//                menu.addMenuVegan(menuVegan);
//                System.out.println("Ingrese los platos que desea tener en el menu especial del dia");
//                String[] menuSpecial = scanner.nextLine().split(" ");
//                menu.addMenuSpecial(menuSpecial);
//                test();
//                break;
//            case 2:
//                System.out.println("Ingrese el precio que desea que tenga el menu normal");
//                double normalPrice = Double.parseDouble(scanner.nextLine());
//                menu.setPriceNormal(normalPrice);
//                System.out.println("Ingrese el precio que desea que tenga el menu vegano");
//                double veganPrice = Double.parseDouble(scanner.nextLine());
//                menu.setPriceVegan(veganPrice);
//                System.out.println("Ingrese el precio que desea que tenga el menu especial");
//                double specialPrice = Double.parseDouble(scanner.nextLine());
//                menu.setPriceSpecial(specialPrice);
//                test();
//                break;
//            case 3:
//                System.out.println("El precio del menu normal es: " + menu.getPriceNormal() + " $");
//                System.out.println("El menu normal del dia es: " + menu.showNormalMenu());
//                System.out.println("El precio del menu vegano es: " + menu.getPriceVegan() + " $");
//                System.out.println("El menu vegano del dia es: " + menu.showVeganMenu());
//                System.out.println("El precio del menu especial es: " + menu.getPriceSpecial() + " $");
//                System.out.println("El menu especial del dia es: " + menu.showSpecialMenu());
//                test();
//                break;
//            case 4:
//                menu.removeMenuNormal();
//                System.out.println("Ingrese los nuevos platos que desea tener en el menu normal del dia");
//                String[] menuNormalM = scanner.nextLine().split(" ");
//                menu.addMenuNormal(menuNormalM);
//                menu.removeMenuVegan();
//                System.out.println("Ingrese los nuevos platos que desea tener en el menu vegano del dia");
//                String[] menuVeganM = scanner.nextLine().split(" ");
//                menu.addMenuVegan(menuVeganM);
//                menu.removeMenuSpecial();
//                System.out.println("Ingrese los nuevos platos que desea tener en el menu especial del dia");
//                String[] menuSpecialM = scanner.nextLine().split(" ");
//                menu.addMenuSpecial(menuSpecialM);
//                test();
//                break;
//            case 5:
//                System.out.println("Vuelva pronto");
//                break;
//            default:
//        }
//    }
//
//    public static void main(String[] args) {
//        new TestMenu().test();
//    }
}
