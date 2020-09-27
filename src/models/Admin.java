/*
 * Copyright (c) 12/9/2020.
 * created by Mateo Pinzon, Harrison Diaz y Juan Jose Ariza
 * All rights reserved
 */

package models;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * modelado segun diagrama Admin, sin niguna logica
 */

public class Admin {

    private static final String ADMIN_NICKNAME = "ADMIN";
    private static final String ADMIN_PASSAWORD = "1234";

//    private String userName;
//    private String passaword;
    private Menu menu;
    private Hotel hotel;

    public Admin(/*String userName, String passaword , */Hotel hotel) {
//        this.userName = userName;
//        this.passaword = passaword;
        menu = new Menu();
//        hotel = new Hotel();
        this.hotel = hotel;
    }

    public Admin() {

    }

    public boolean verifiqueIndenty(String name, String passaword){
      //  String message = "usuario y/o contraseña invalido";
        //if (){
//            message = "Acceso concedido";
//        }
        return name.equals(ADMIN_NICKNAME) && passaword.equals(ADMIN_PASSAWORD);//message;
    }

    public void addMenu(Menu menu){
        hotel.menus.add(menu);
    }

    /**
     * agrega usuarios
     * @param user
     */
    public void addUser(User user){
        try{
            hotel.userTreeSet.add(user);
        }
        catch (NullPointerException exception){
            System.out.println("dato invalido");
        }
    }

    /**
     * muestra el usuario consultado por ID
     * @param id
     * @return
     */
    public String searchUser(long id){
        String info = "";
        for (User user: hotel.userTreeSet) {
            if (user.getId() == id){
                info = user.viewUser();
                return info;
            }
        }
        return info;
    }

    /**
     * Para encontrar el total de habitaciones
     * @return el numero total
     */
    public int getTotalRooms(){
        return hotel.rooms.size();
    }

    /**
     * Metodo para contar cuantas habitaciones
     * hay en una calidad en especifico
     * @param quality
     * @return
     */
    public int getQualityCounter(Quality quality){
        int counter = 0;
        for (int i = 0; i < hotel.rooms.size(); i++) {
            if(hotel.rooms.get(i).getQuality() == quality){
                counter++;
            }
        }
        return counter;
    }

    /**
     * mirar el total de habitaciones no ocupadas del establecimiento
     * @return total de habitaciones disponibles
     */
    public int getAvailable(){
        int counter = 0;
        for (int i = 0; i < hotel.rooms.size(); i++) {
            if(!hotel.rooms.get(i).isOcupation()){
                counter++;
            }
        }
        return counter;
    }

    /**
     * mirar el total de habitaciones  ocupadas del establecimiento
     * @return total de habitaciones disponibles
     */
    public int getDisavailable(){
        return hotel.rooms.size() - getAvailable();
    }

    /**
     * Para meterle los numero automaticamente los numeros de cada habitacion
     */
    private void SetNumberRooms(){
        int counter = 0;
        for (int i = 0; i < hotel.rooms.size(); i++) {
            counter++;
            hotel.rooms.get(i).setNumber(counter);
        }
    }

    /**
     * Metodo para aumentar el numero de habitaciones
     * @param room
     */
    public void add(Room room){
        hotel.rooms.add(room);
        SetNumberRooms();
    }

    /**
     * Para decir que una habitacion esta fuera de serivicio
     * @param numb
     */
    public void outOfService(int numb){
        hotel.rooms.get(numb).setOcupation(true);
    }


}
