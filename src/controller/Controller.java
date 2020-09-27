/*
 * Copyright (c) 27/9/2020.
 * created by Mateo Pinzon, Harrison Diaz y Juan Jose Ariza
 * All rights reserved
 */

package controller;

import models.Admin;
import models.Hotel;
import models.Menu;
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
//////////////////////////////////REALCIONES DE MENU////////////////////////////////////////////////////////
    /**
     * relacion de la interfaz de seleccion de usuario
     */
    public void menuInitalOptions(){
        switch (view.selectionMenu()){
            case View.MENU_OPTION_ONE:
                verifyAdmin();
                break;
            case View.MENU_OPTION_TWO:

                break;
        }
    }

    /**
     * relaciona todas las opciones que tiene el admin
     */
    public void menuAdmin(){
        switch (view.adminOption()){
            case View.MENU_OPTION_ONE:
                addMenu();
                break;
        }
    }
//////////////////////////////////////////////RELACIONES////////////////////////////////////////////////////////////
    public void verifyAdmin(){
        boolean reference = admin.verifiqueIndenty(view.nickName(), view.passaword());
        String status = reference ? "Acceso concedido" :"Acceso denegado";
        view.viewMessages(status);
        if (reference){
            menuAdmin();
        } else {
            verifyAdmin();
        }
    }

    public void addMenu(){
        view.viewMessages(admin.addMenu(new Menu(view.menuName(), view.menuContains(), view.menuPrice())));
    }

    public static void main(String[] args) {
        new Controller();
    }
}

