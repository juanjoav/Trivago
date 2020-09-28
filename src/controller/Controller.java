/*
 * Copyright (c) 27/9/2020.
 * created by Mateo Pinzon, Harrison Diaz y Juan Jose Ariza
 * All rights reserved
 */

package controller;

import models.*;
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
                menuUser();
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
            case View.MENU_OPTION_TWO:
                    addUserAdmin();
                    break;
                    case View.MENU_OPTION_TRHEE:
                        viewUsers();
                        break;
        }
    }

    public void menuUser(){
        switch (view.userMenu()) {
            case View.MENU_OPTION_ONE:
                addUserRegister();
                break;
            case View.MENU_OPTION_TWO:
                break;
        }
    }


//////////////////////////////////////////////RELACIONES////////////////////////////////////////////////////////////
    public void verifyAdmin(){
        boolean reference = admin.verifiqueIndenty(view.nickName(), view.password());
        String status = reference ? "Acceso concedido" :"Acceso denegado";
        view.viewMessages(status);
        if (reference){
            menuAdmin();
        } else {
            verifyAdmin();
        }
    }

    public void addMenu(){
        try {
            view.viewMessages(admin.addMenu(new Menu(view.menuName(), view.menuContains(), view.menuPrice())));
        }
        catch (NumberFormatException ex){
            view.viewMessages(View.MESSAGE_FORMAR_EX);
            addMenu();
        }
        menuAdmin();
    }

    public void removeMenu(){
        admin.removeMenu(view.deleteMenu());
    }

    ////////////////////////////////////////////////USER////////////////////////////////////////


    public void addUserRegister(){
        try {
            hotel.addUser(new User(view.nickName(), view.getphone(), view.getId(), view.password()));
        } catch (NumberFormatException | NullPointerException ex){
            view.viewMessages(View.MESSAGE_FORMAR_EX);
            addUserRegister();
        }
        menuUser();
    }


    public void addUserAdmin(){
        //hotel.addUser(new User(view.nickName(), view.getId(), view.getphone(), PayEvent.valueOf(view.getCashEvent()),Entry.valueOf(view.entryCondition())));
        try {
            hotel.addUser(new User(view.nickName(), view.getphone(), view.getId(), view.password()));
        } catch (NumberFormatException | NullPointerException ex){
            view.viewMessages(View.MESSAGE_FORMAR_EX);
            addUserAdmin();
        }
        menuAdmin();
    }

    public void viewUsers(){
        String [] userList = admin.showUser();
        view.viewList(userList);
        menuAdmin();
    }

    public static void main(String[] args) {
        new Controller();
    }
}

