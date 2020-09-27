/*
 * Copyright (c) 27/9/2020.
 * created by Mateo Pinzon, Harrison Diaz y Juan Jose Ariza
 * All rights reserved
 */

package controller;

import models.Admin;
import models.Hotel;
import view.View;

public class Controller {

    private Hotel hotel;
    private Admin admin;
    private View view;

    public Controller() {
        hotel = new Hotel();
        admin = new Admin(hotel);
        view = new View();
        menuInitalOptions();
    }

    public void menuInitalOptions(){
        switch (view.selectionMenu()){
            case View.MENU_OPTION_ONE:

                break;
            case View.MENU_OPTION_TWO:

                break;
        }
    }

    public void verifyAdmin(){
        boolean reference = admin.verifiqueIndenty(view.nickName(), view.passaword());
        //String status =  ? "Acceso concedido" : "Acceso denegado";
//        if (){
//
//        }
    }

    public static void main(String[] args) {
        new Controller();
    }
}

