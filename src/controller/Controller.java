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
    public void menuInitalOptions() /*throws NumberFormatException*/{
        try {
            switch (view.selectionMenu()){
                case View.MENU_OPTION_ONE:
                    verifyAdmin();
                    break;
                case View.MENU_OPTION_TWO:
                    menuUser();
                    break;
            }
        }
        catch (NumberFormatException ex){
            view.viewMessages(View.ERROR_VALUES);
            menuInitalOptions();
        }
    }

    ////////////////////////////////////////////////MENU DEL ADMIN Y SUBS MENUS//////////////////////////////////////////////
    /**
     * relaciona todas las opciones que tiene el admin
     */
    public void menuAdmin(){
        try {
            switch (view.adminOption()){
                case View.MENU_OPTION_ONE:
                    adminMenu();
                    break;
                case View.MENU_OPTION_TWO:
                    adminUser();
                    break;
                case View.MENU_OPTION_TRHEE:
                    //viewUsers();
                    break;
                    case View.MENU_OPTION_FOUR:
                        menuInitalOptions();
                        break;
            }
        } catch (NumberFormatException ex){
            view.viewMessages(View.ERROR_VALUES);
            menuAdmin();
        }

    }

    /**
     * RELACIONA TODAS LAS OPCIONES QUE DISPONE EL ADMIN PARA EL MENU
     */
    public void adminMenu(){
        switch (view.adminMenuOption()){
            case View.MENU_OPTION_ONE:
                addMenu();
                break;
            case View.MENU_OPTION_TWO:
                removeMenu();
                break;
            case View.MENU_OPTION_TRHEE:
                modifyMenu();
                break;
            case View.MENU_OPTION_FOUR:
                viewMenus();
                break;
            case View.MENU_OPTION_FIVE:
                menuAdmin();
                break;
            default:
                adminMenu();
        }
    }

    public void adminUser(){
        switch (view.adminUserMenu()){
            case View.MENU_OPTION_ONE:
                addUserAdmin();
                break;
            case View.MENU_OPTION_TWO:
                viewUsers();
                break;
            case View.MENU_OPTION_TRHEE:
                searchUser();
                break;
            case View.MENU_OPTION_FOUR:
                menuAdmin();
                break;
            default:
                adminUser();
        }
    }

    ///////////////////////////////////////////////INTERFAZ DE USUARIOS Y SUBS MENUS////////////////////////////////////////
    /**
     * MENU DE USUARIOS
     */
    public void menuUser(){
        switch (view.userMenu()) {
            case View.MENU_OPTION_ONE:
                addUserRegister();
                break;
            case View.MENU_OPTION_TWO:
                break;
        }
    }


//////////////////////////////////////////////RELACIONES ADMIN ///////////////////////////////////////////////////////////
    /**
     * VERIFICA SI EL ADMIN ES EL CORRECTO
     */
    public void verifyAdmin(){
        boolean reference = admin.verifiqueIndenty(view.nickName(), view.password());
        String status = reference ? "Acceso concedido" :"Acceso denegado";
        view.viewMessages(status);
        if (reference){
            menuAdmin();
        } else {
            menuInitalOptions();
        }
    }

    /**
     * METODO QUE AGREGA MENUS
     */
    public void addMenu(){
        try {
            view.viewMessages(admin.addMenu(new Menu(view.menuName(), view.menuContains(), view.menuPrice())));
        }
        catch (NumberFormatException ex){
            view.viewMessages(View.MESSAGE_FORMAR_EX);
            adminMenu();
        }
        adminMenu();
    }

    /**
     * METODO QUE RETIRA LOS MENUS
     */
    public void removeMenu(){
        admin.removeMenu(view.deleteMenu());
        adminMenu();
    }

    /**
     * METODO QUE QUE MODIFICA
     */
    public void modifyMenu(){
        admin.removeMenu(view.deleteMenu());
        addMenu();
    }

    /**
     * METODO QUE PERMITE MOSTRAR UNA LISTA DE USUARIOS
     */
    public void viewUsers(){
        String [] userList = admin.showUser();
        view.viewList(userList);
        adminUser();
    }

    /**
     * METODO PARA BUSCAR UN USUARIO
     */
    public void searchUser() /*throws InterruptedException*/ {
        view.viewMessages(View.SEARCH_MESSAGE);
        view.viewMessages(admin.searchUser(view.getId()));
        adminUser();
    }
    ////////////////////////////////////////////////USER////////////////////////////////////////

    /**
     * PERMITE QUE EL USUARIO SE REGISTRE A SI MISMO
     */
    public void addUserRegister(){
        try {
            hotel.addUser(new User(view.nickName(), view.getphone(), view.getId(), view.password()));
        } catch (NumberFormatException | NullPointerException ex){
            view.viewMessages(View.MESSAGE_FORMAR_EX);
            addUserRegister();
        }
        menuUser();
    }

    /**
     * PERMITE AL ADMIN AGREGAR USUARIOS
     */
    public void addUserAdmin(){
        //hotel.addUser(new User(view.nickName(), view.getId(), view.getphone(), PayEvent.valueOf(view.getCashEvent()),Entry.valueOf(view.entryCondition())));
        try {
            hotel.addUser(new User(view.nickName(), view.getphone(), view.getId(), view.password()));
        } catch (NumberFormatException | NullPointerException ex){
            view.viewMessages(View.MESSAGE_FORMAR_EX);
            adminUser();
        }
        adminUser();
    }

    ////////////////////////////////////////DE USO DE ADMIN Y USER////////////////////////////////////

    public void viewMenus(){
        view.viewList(hotel.viewMenus());
        adminMenu();
    }

    public static void main(String[] args) {
        new Controller();
    }
}

