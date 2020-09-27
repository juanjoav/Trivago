/*
 * Copyright (c) 19/9/2020.
 * created by Mateo Pinzon, Harrison Diaz y Juan Jose Ariza
 * All rights reserved
 */

package models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Clase para administrar la variedad de habitaiones
 */
public class AdminRoom {
    private ArrayList<Room> rooms;

    public AdminRoom() {
       rooms = new ArrayList<>();
       for (int i = 0; i < 100; i++) {
           rooms.add(new Room(Quality.REGULAR));
        }
    }

    /**
     * Para encontrar el total de habitaciones
     * @return el numero total
     */
    public int getTotalRooms(){
        return rooms.size();
    }

    /**
     * Metodo para contar cuantas habitaciones
     * hay en una calidad en especifico
     * @param quality
     * @return
     */
    public int getQualityCounter(Quality quality){
        int counter = 0;
        for (int i = 0; i < rooms.size(); i++) {
            if(rooms.get(i).getQuality() == quality){
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
        for (int i = 0; i < rooms.size(); i++) {
            if(!rooms.get(i).isOcupation()){
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
        return rooms.size() - getAvailable();
    }


    /**
     * Metodo para aumentar el numero de habitaciones
     * @param room
     */
    public void add(Room room){
        rooms.add(room);

    }

    /**
     * Para decir que una habitacion esta fuera de serivicio
     * @param numb
     */
    public void outOfService(int numb){
        rooms.get(numb).setOcupation(true);
    }
    /**
     * Recupera el room para hacer modificaciones
     * @param iterator numero de cual habitacion
     * @return
     */
    public Room getRoom(int iterator){
        return rooms.get(iterator);
    }
}
