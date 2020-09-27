/*
 * Copyright (c) 26/9/2020.
 * created by Mateo Pinzon, Harrison Diaz y Juan Jose Ariza
 * All rights reserved
 */

package test;

import models.*;

public class TestUser {

    /**
     * agregar excepciones al usuario para valores  invalidos
     * @param args
     */
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        Admin admin = new Admin(hotel);
        User user = new User();
//
//        admin.addUser(new User("Mateo",2019,999999, PayEvent.EFECTIVO, Entry.valueOf("WALKING")));
//        admin.addUser(new User("juan",2009,999999, PayEvent.EFECTIVO, Entry.valueOf("WALKING")));
//        admin.addUser(new User("ateo",2019,999999, PayEvent.EFECTIVO, Entry.valueOf("WALKING")));
//        //hotel.addUser(null);
//       // System.out.println(hotel.searchById(2019L));
//        //hotel.view();
//        System.out.println("-------------");
//        //hotel.viewUserInformation();
//        System.out.println(admin.searchUser(2009l));
////        admin.addMenu(new Menu("veg", "holi", 3.4));
////        String [] list = hotel.viewMenus();
////        for (String text:list) {
////            System.out.println(text);
////        }
    }
}
