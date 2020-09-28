/*
 * Copyright (c) 12/9/2020.
 * created by Mateo Pinzon, Harrison Diaz y Juan Jose Ariza
 * All rights reserved
 */

package models;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

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
        this.hotel = hotel;
    }

    public Admin() {

    }

    public boolean verifiqueIndenty(String name, String passaword){
        return name.equals(ADMIN_NICKNAME) && passaword.equals(ADMIN_PASSAWORD);
    }

    /**
     * Metodo que le permite a un administrador añadir un menua una lista
     * @param menu menu que desea ingresar
     */
    public String addMenu(Menu menu){
        String message = "";
        hotel.menus.add(menu);
        return "Menu agregado";
    }

    /**
     *Metodo que le permite al administrador eliminar un menu
     * @param menuName el nombre del menu que se desea eliminar
     */
    public void removeMenu(String menuName){
        for (int i = 0; i < hotel.menus.size() ; i++) {
            if(hotel.menus.get(i).getName().equalsIgnoreCase(menuName)){
                hotel.menus.remove(i);
            }
        }
    }

    /**
     * Metodo que retorna todos la lista de usuarios
     * @return
     */
    public String[] showUser(){
        String[] aux = new String[hotel.userTreeSet.size()];
        int count = 0;
        for (User i: hotel.userTreeSet) {
            aux[count] = i.viewUser();
            count++;
        }
        return aux;
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
        return hotel.getSizeRooms();
    }

    /**
     * Metodo para contar cuantas habitaciones
     * hay en una calidad en especifico
     * @param quality
     * @return
     */
    public int getQualityCounter(Quality quality){
        int counter = 0;
        for (int i = 0; i < hotel.getSizeRooms(); i++) {
            if(hotel.getRoom(i).getQuality() == quality){
                counter++;
            }
        }
        return counter;
    }

    /**
     * Metodo para contar cuantas habitaciones estan disponibles
     * hay en una calidad en especifico
     * @param quality
     * @param ocupation
     * @return
     */
    public int getAvariableQuality(Quality quality, boolean ocupation){
        int counter = 0;
        for (int i = 0; i < hotel.getSizeRooms(); i++) {
            if(hotel.getRoom(i).getQuality() == quality && hotel.getRoom(i).isOcupation() == ocupation){
                counter++;
            }
        }
        return counter;
    }


    /**
     * mirar el total de habitaciones no ocupadas del establecimiento
     * @return total de habitaciones disponibles
     */
    public int getCounterOcupation(boolean ocupation){
        int counter = 0;
        for (int i = 0; i < hotel.getSizeRooms(); i++) {
            if(hotel.getRoom(i).isOcupation() == ocupation){
                counter++;
            }
        }
        return counter;
    }

    /**
     * Metodo para aumentar el numero de habitaciones
     * @param room
     */
    public void addRoom(Room room){
        hotel.addRoom(room);
    }

    /**
     * Metodo para aumentar el numero de habitaciones
     * @param quality
     */
    public void addRoom(Quality quality){
        hotel.addRoom(quality);
    }

    /**
     * Para decir que una habitacion esta fuera de serivicio
     * @param numb
     */
    public void outOfService(int numb){
        hotel.getRoom(numb).setOcupation(true);
    }

    /**
     *Para obtener cualquier habitacion del arreglo
     * @param index el numero de la habitacion
     * @return
     */
    public Room getRoom(int index){
        return hotel.getRoom(index);
    }

    /**
     * Metodo para obtener las habitaciones
     * apartir de la calidad de las mismas
     * @param quality
     * @return
     */
    public Room[] getAnyRoom(Quality quality){
        Room[] aux = new Room[getQualityCounter(quality)];
        int counter = 0;
        for (int i = 0; i < hotel.getSizeRooms(); i++) {
            if(hotel.getRoom(i).getQuality() == quality){
                aux[counter] = hotel.getRoom(i);
                counter++;
            }
        }
        return aux;
    }

    /**
     * Metodo para obtener las habitaciones
     * apartir de la calidad de las mismas
     * @param ocupation
     * @return
     */
    public Room[] getAnyRoom(boolean ocupation){
        Room[] aux = new Room[getCounterOcupation(ocupation)];
        int counter = 0;
        for (int i = 0; i < hotel.getSizeRooms(); i++) {
            if(hotel.getRoom(i).isOcupation() == ocupation){
                aux[counter] = hotel.getRoom(i);
                counter++;
            }
        }
        return aux;
    }
    public Room[] getAnyRoom(int[] numbers){
        Room[] rooms = new Room[numbers.length];
        int counter = 0;
        for (int i = 0; i < numbers.length; i++) {
            rooms[counter] = hotel.getRoom(numbers[i]);
            counter++;
        }
        return  rooms;
    }
    /**
     * Metodo para mostrar la informacion de una habitacion en la posicion
     * @param index numero de la habitacion
     * @return mensaje completo
     */
    public String toStringRoom(int index){
        return "N°: "+hotel.getRoom(index).getNumber()+" Calidad: "+hotel.getRoom(index).getQuality()+"  Estado: "+(hotel.getRoom(index).isOcupation()?"Ocupado":"No ocuapdo");
    }
}
