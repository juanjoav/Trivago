
/*
 * Copyright (c) 12/9/2020.
 * created by Mateo Pinzon, Harrison Diaz y Juan Jose Ariza
 * All rights reserved
 */

package models;

import java.util.ArrayList;
import java.util.TreeSet;

public class Hotel {

    private TreeSet<User> userTreeSet;
    private ArrayList<Room> rooms;


    public void addUser(User user){
        userTreeSet.add(user);
    }

    public void view(){
        System.out.println(userTreeSet);
    }

    public void viewUserInformation(){

    }

    public Hotel() {
        userTreeSet = new TreeSet<>();
        rooms = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            rooms.add(new Room(i,Quality.REGULAR));
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
     * mirar el total de habitaciones no ocupadas del establecimiento
     * @return total de habitaciones disponibles
     */
    public int getEconomic(){
        int counter = 0;
        for (int i = 0; i < rooms.size(); i++) {
            if(rooms.get(i).getQuality() == Quality.ECONOMIC){
                counter++;
            }
        }
        return counter;
    }
    /**
     * mirar el total de habitaciones Regular del establecimiento
     * @return total de habitaciones disponibles
     */
    public int getRegular(){
        int counter = 0;
        for (int i = 0; i < rooms.size(); i++) {
            if(rooms.get(i).getQuality() == Quality.REGULAR){
                counter++;
            }
        }
        return counter;
    }

    /**
     * mirar el total de habitaciones Premium del establecimiento
     * @return total de habitaciones disponibles
     */
    public int getPremium(){
        int counter = 0;
        for (int i = 0; i < rooms.size(); i++) {
            if(rooms.get(i).getQuality() == Quality.PREMIUM){
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
        int counter = 0;
        for (int i = 0; i < rooms.size(); i++) {
            if(rooms.get(i).isOcupation()){
                counter++;
            }
        }
        return counter;
    }
    /**
     * Para meterle los numero automaticamente los numeros de cada habitacion
     */
    private void SetNumberRooms(){
        int counter = 0;
        for (int i = 0; i < rooms.size(); i++) {
            counter++;
            rooms.get(i).setNumber(counter);
        }
    }

    /**
     * Metodo para aumentar el numero de habitaciones
     * @param room
     */
    public void add(Room room){
        rooms.add(room);
        SetNumberRooms();
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
