/*
 * Copyright (c) 27/9/2020.
 * created by Mateo Pinzon, Harrison Diaz y Juan Jose Ariza
 * All rights reserved
 */

package controller;

import models.*;
import view.View;

import java.time.LocalDate;

/**
 * Esta clase hace la comunicacion entre la consola y la parte logica
 * tambien los llamados de los mismos
 * @Author Mateo Pinzon, Harrison Diaz y Juan Ariza
 * @Date 27/09/2020
 */
public class Controller {

    private Hotel hotel;
    private Admin admin;
    private View view;
    private Event event;
    private Reservation reservation;
    private Pay pay;

    public Controller() {
        hotel = new Hotel();
        admin = new Admin(hotel);
        view = new View();
        event = new Event();
        reservation = new Reservation();
        pay = new Pay();
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
                    adminsEventsMenu();
                    break;
                    case View.MENU_OPTION_SEVEN:
                        pay();
                default:
                    menuInitalOptions();
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
                adminMenu();
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
                controlRoomMenu();
                break;
            case View.MENU_OPTION_TWO:
                modifyRoom();
                break;
            case View.MENU_OPTION_TRHEE:
                disableRoom();
                break;
            case View.MENU_OPTION_FOUR:
                addRoom();
                break;
            default:
                menuAdmin();
        }
    }

    /**
     * Metodo que permite ver los subMenus de opciones de cada habitacion
     */
    public void controlRoomMenu(){
        switch (view.viewRoomsMenu()){
            case View.MENU_OPTION_ONE:
                roomOcupation();
                break;
            case View.MENU_OPTION_TWO:
                searchPerQuality();
                break;
            case View.MENU_OPTION_TRHEE:
                searchPerStatus();
                break;
            default:
                menuAdmin();
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
                signInUser();
                break;
            case View.MENU_OPTION_TRHEE:
                menuInitalOptions();
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
        String status = reference ? View.ACCESS_GRANTED_MESSAGE:View.ACCESS_DENIED_MESSAGE;
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
            menuAdmin();
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

    /**
     *
     */
    public void pay(){
        view.viewMessages(View.MESSAGE_ITERATIONS);
        int rounds = view.getInt();
        Room[] rooms = new Room[rounds];
        for (int i = 0; i < rounds; i++) {
            rooms[i] = hotel.getRoom(view.numberRoom());
        }
        paymentType();
        switch (view.allInclude()){
            case 1:
                view.showPay(pay.getTotalFinal(true,rooms));
                break;
            case 2:
                view.showPay(pay.getTotalFinal(false,rooms));
                break;
            default:
                menuAdmin();
        }
        menuAdmin();
    }

    public void paymentType(){
        pay.setPayEvent(PaymentType.valueOf(view.getPaymentType()));
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
        controlRoomMenu();
    }

    /**
     * Metodo que retorna la cantidad de habitaciones consultadas por calidad
     */
    public void searchPerQuality(){
        try {
            view.viewMessages(View.ROOM_PER_QUALITY + admin.getQualityCounter(Quality.valueOf(view.obtainQuality())));
            controlRoomMenu();
        } catch (IllegalArgumentException exception){
            view.viewMessages(View.ERROR_VALUES);
            controlRoomMenu();
        }
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

    /**
     * Metodo que permite modificar la condicion de una habitacion
     */
    public void disableRoom(){
        admin.outOfService(view.numberRoom(), view.disablesRoom());//true ingresa fuera de servicio / false lo opuesto
        view.viewMessages(View.CHANGES_MESSAGE);
        adminRoom();
    }

    /**
     * Metodo que permite agregar una habitacion
     */
    public void addRoom(){
        admin.addRoom(new Room(Quality.valueOf(view.obtainQuality())));
        view.viewMessages(View.CHANGES_MESSAGE);
        adminRoom();
    }
    /**
     * Metodo que permite buscar una habitacion disponible o ocupada segun la calidad
     */
    public void searchPerStatus(){
        view.viewMessages(View.ROOM_PER_QUALITY + "\n" + admin.getAvariableQuality(Quality.valueOf(view.obtainQuality()),view.reservationOption()));
        adminRoom();
    }

    //////////////////////////////////////////EVENTS////////////////////////////////////////

    /**
     * Metodo para mostrar el menu de eventos del administrador
     */
    public void adminsEventsMenu(){
        switch (view.adminEventsMenu()){
            case View.MENU_OPTION_ONE:
                clientEntry();
                break;
            case View.MENU_OPTION_TWO:
                clientExit();
                break;
            case View.MENU_OPTION_TRHEE:
                generateReservation();
                adminsEventsMenu();
                break;
            case View.MENU_OPTION_FOUR:
                changeSeason();
                break;
            default:
                menuAdmin();
        }
    }

    /**
     * Metodo para agregar el registro del usuario
     */
    public void clientEntry(){
        event.assingRoom(admin.getRoom(view.numberRoom()));
        view.viewMessages(View.MESSAGE_EVENT_CHECK_IN);
        adminsEventsMenu();
    }

    /**
     * Metodo para registrar la salida de un usuario
     */
    public void clientExit(){
        event.outRooms(admin.getRoom(view.numberRoom()));
        view.viewMessages(View.MESSAGE_EVENT_CHECK_OUT);
        adminsEventsMenu();
    }

    /**
     * Metodo que permite generar una reservacion desde el admin
     */
    public void generateReservation(){
        reservation.makeBooking(new Event(LocalDate.parse(view.addInitialDate()),LocalDate.parse(view.addIEndingDate()), hotel.searchUser(view.getId()),admin.getRoom(view.numberRoom())));
        view.viewMessages(View.RESERVATION_MESSAGE);
        //adminsEventsMenu();
    }

    /**
     * metodo que permite cambiar una temporada
     */
    public void changeSeason(){
        view.viewMessages(View.CHANGE_SEASON);
        pay.setSeason(Season.valueOf(view.changeSeason().toUpperCase()));
        view.viewMessages(View.MESSAGE_CHANGE_SEASON);
        adminsEventsMenu();
    }
    ////////////////////////////////////////////////USER////////////////////////////////////////////////

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
        //hotel.addUser(new User(view.nickName(), view.getId(), view.getphone(), PaymentType.valueOf(view.getCashEvent()),Entry.valueOf(view.entryCondition())));
        try {
            //System.out.println(hotel.addUser(new User(view.nickName(), view.getphone(), view.getId(), view.password())));
            view.viewMessages(hotel.addUser(new User(view.nickName(), view.getphone(), view.getId(), view.password())));
        } catch (NumberFormatException | NullPointerException ex){
            view.viewMessages(View.MESSAGE_FORMAR_EX);
            adminUser();
        }
        adminUser();
    }

    /**
     * Metodo que permite la verificacion del usuario
     */
    public void signInUser(){
        boolean status = hotel.verifyData(view.getId(), view.getPassaword());
        String condition = status ? View.ACCESS_GRANTED_MESSAGE : View.ACCESS_DENIED_MESSAGE;
        view.viewMessages(condition);
        if (status){
            menuUserOptions();
        } else {
            menuUser();
        }
    }

    /**
     * Metodo para mostrar las opciones del usuario
     */
    public void menuUserOptions(){
        switch (view.menuUser()){
            case View.MENU_OPTION_ONE:
                viewMenus();
                menuUserOptions();
                break;
            case View.MENU_OPTION_TWO:
                menuUserOptions();
                break;
            case View.MENU_OPTION_TRHEE:
                generateReservation();
                menuUserOptions();
                break;
            case View.MENU_OPTION_FOUR:
                pay();
            default:
                menuInitalOptions();
        }
        menuInitalOptions();
    }


    ////////////////////////////////////////DE USO DE ADMIN Y USER////////////////////////////////////

    /**
     * METODO QUE PERMITE MOSTRAR LOS CONTENIDOS DE LOS MENUS
     */
    public void viewMenus(){
        view.viewList(hotel.viewMenus());
    }

    /**
     * Metodo que permite buscar habitaciones por el usuario
     */
    public void userCheckRoom(){
        admin.getAnyRoom(Quality.valueOf(view.obtainQuality()));
        menuUserOptions();
    }

    public static void main(String[] args) {
        new Controller();
    }
}

