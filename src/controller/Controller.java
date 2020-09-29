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
     * METODO QUE GENERA LAS OPCIONES DEL MENU INICIAL PARA EL USUARIO Y ADMINISTRADOR
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
     * METODO QUE RELACIONA TODAS LAS OPCIONES QUE TIENE EL ADMIN
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
                case View.MENU_OPTION_TRHEE:            //HABITACIONES
                    adminRoom();
                    break;
                    case View.MENU_OPTION_FOUR:
                        modifyAdminName();
                        break;
                        case View.MENU_OPTION_FIVE:
                            modifyAdminPassword();
                            break;
                            case View.MENU_OPTION_SIX:
                                menuInitalOptions();
                                break;
            }
        } catch (NumberFormatException ex){
            view.viewMessages(View.ERROR_VALUES);
            menuAdmin();
        }

    }

    /**
     * METODO QUE RELACIONA TODAS LAS OPCIONES QUE DISPONE EL ADMIN PARA EL MENU
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

    /**
     * METODO QUE RELACIONA TODAS LAS OPCIONES QUE DISPONE EL ADMIN CON RESPECTO A LOS USUARIOS
     */
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

    ///////////////////////////////////ROOM CONTROL///////////////////////////////////////////
    public void adminRoom(){
        switch (view.adminUserRoom()){
            case View.MENU_OPTION_ONE:
                roomOcupation();
                break;
                case View.MENU_OPTION_TWO:
                    modifyRoom();
                    break;
        }
    }



    ///////////////////////////////////////////////INTERFAZ DE USUARIOS Y SUBS MENUS////////////////////////////////////////
    /**
     * METODO QUE PERMITE LAS FUNCIONES BASICAS DEL USUARIO
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
     * MODIFICA EL USERNAME DEL ADMIN
     */
    public void modifyAdminName(){
        admin.setAdminNickName(view.nickName());
        view.viewMessages(View.CHANGES_MESSAGE);
        menuAdmin();
    }

    /**
     * MODIFICA LA CONTRASEÑA DEL ADMIN
     */
    public void modifyAdminPassword(){
        admin.setAdminPassword(view.password());
        view.viewMessages(View.CHANGES_MESSAGE);
        menuAdmin();
    }

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
     * METODO QUE PERMITE BUSCAR UN USUARIO
     */
    public void searchUser() /*throws InterruptedException*/ {
        view.viewMessages(View.SEARCH_MESSAGE);
        view.viewMessages(admin.searchUser(view.getId()));
        adminUser();
    }

    ////////////////////////////////////ROOMS CONTROL ADMIN///////////////////////////////////////////

    /**
     * Metodo que permite consultar cuantas habitaciones estan ocupadas
     */
    public void roomOcupation(){
        boolean eventRoom = view.reservationOption();
        if (eventRoom){
            view.viewMessages(View.ROOM_OCUPATED_MESSAGE);
            view.viewMessages("" + admin.getCounterOcupation(eventRoom));
        }
        else {
            view.viewMessages(View.ROOM_FREE_MESSAGE);
            view.viewMessages("" + admin.getCounterOcupation(eventRoom));
        }
        adminRoom();
    }

    /**
     * Metodo que permite modificar una habitacion
     */
    public void modifyRoom(){
        try{
            admin.getRoom(view.numberRoom()).setQuality(Quality.valueOf(view.obtainQuality()));
            view.viewMessages(View.CHANGES_MESSAGE);
        }
        catch (IllegalArgumentException ex){
            view.viewMessages(View.ERROR_VALUES);
            adminRoom();
        }
        adminRoom();
    }

    public void disableRoom(){

    }
    ////////////////////////////////////////////////USER////////////////////////////////////////

    /**
     * METODO QUE PERMITE QUE EL USUARIO SE REGISTRE A SI MISMO
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
     * METODO QUE PERMITE AL ADMIN AGREGAR USUARIOS
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

    /**
     * METODO QUE PERMITE MOSTRAR LOS CONTENIDOS DE LOS MENUS
     */
    public void viewMenus(){
        view.viewList(hotel.viewMenus());
        adminMenu();
    }

    public static void main(String[] args) {
        new Controller();
    }
}

