
/*
 * Copyright (c) 12/9/2020.
 * created by Mateo Pinzon, Harrison Diaz y Juan Jose Ariza
 * All rights reserved
 */

package models;


import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Hotel {

    Menu menu;
    private TreeSet<User> userTreeSet;
    private List<Room> rooms;

    public Hotel() {
        userTreeSet = new TreeSet<>();
        rooms = new ArrayList<Room>();
        for (int i = 0; i < 100; i++) {
            rooms.add(new Room(i,Quality.REGULAR));
        }
    }

    /**
     * agrega usuarios
     * @param user
     */
    public void addUser(User user){
        try{
            userTreeSet.add(user);
        }
        catch (NullPointerException exception){
            System.out.println("dato invalido");
        }
    }


    /**
     * muestra elementos de la lista, solo pruebas
     */
    public void view(){
        for (User user:userTreeSet) {
            System.out.println(user.viewUser());
        }
    }

    /**
     * muestra el usuario consultado por ID
     * @param id
     * @return
     */
//    public String searchUser(long id){
//        String info = "";
//        for (User user:userTreeSet) {
//            if (user.getId() == id){
//                info = user.viewUser();
//                return info;
//            }
//        }
//        return info;
//    }
    /**
     * muestra el usuario consultado por ID
     * @param id
     * @return
     */
    public User searchUser(long id){
        User info;
        for (User user:userTreeSet) {
            if (user.getId() == id){
                info = user.getUser();
                return info;
            }
        }
        return new User(" ",0l,0l,PayEvent.EFECTIVO,Entry.WALKING);
    }
    public void viewUserInformation(){

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

    /**
     * Para decir que una habitacion esta fuera de serivicio
     * @param numb
     */
    public void outOfService(int numb){
        rooms.get(numb).setOcupation(true);
    }
}
