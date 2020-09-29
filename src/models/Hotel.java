
/*
 * Copyright (c) 12/9/2020.
 * created by Mateo Pinzon, Harrison Diaz y Juan Jose Ariza
 * All rights reserved
 */

package models;


import java.util.*;

public class Hotel {

    public LinkedList<Menu> menus;
    public TreeSet<User> userTreeSet;
    private List<Room> rooms;
    private Pay pay;

    public User user;
    public Admin admin;

    /**
     * Metodo costructor por defeccto
     */
    public Hotel() {
        menus = new LinkedList();
        userTreeSet = new TreeSet<>();
        rooms = new ArrayList<Room>();
        user = new User();
        pay = new Pay();
        inicializeRooms();
    }

    /**
     * Metodo que nos permite agregar un nuevo usuario a la lista
     * @param user usuario a ser creado
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
     * Metodo que permite verificar usuarios en una lista de usuarios
     * @param id el identificador para buscar
     * @param passaword la contraseña para permitir acceso
     * @return si el usuario y parametro son validos
     */
    public boolean verifyData(Long id, String passaword){
        for (User user:userTreeSet) {
            if (user.getId() == id && user.getPassword().equals(passaword)){
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo que retorna todos los menus disponibles
     * @return
     */
    public String[] viewMenus(){
        String[] aux = new String[menus.size()];
        for (int i = 0; i < aux.length; i++) {
            aux[i] = menus.get(i).formatMenus();
        }
        return aux;
    }

    /**
     * Coloca el numero de las habitaciones
     */
    private void SetNumberRooms(){
        int counter = 0;
        for (int i = 0; i < rooms.size(); i++) {
            rooms.get(i).setNumber(i);
            counter++;
        }
    }

    /**
     * pasa por quemado un numero determinado de habiotaciones o minimo de estas
     */
    private void inicializeRooms(){
        for (int i = 0; i < 8; i++) {
            rooms.add(new Room(Quality.PREMIUM));
            rooms.add(new Room(Quality.ECONOMICA));
            rooms.add(new Room(Quality.REGULAR));
        }
    }
    /**
     * Metodo para aumentar el numero de habitaciones
     * @param room
     */
    public void addRoom(Room room){
        rooms.add(room);
        SetNumberRooms();
    }

    /**
     * Metodo para aumentar el numero de habitaciones
     * @param quality
     */
    public void addRoom(Quality quality){
        rooms.add(new Room(quality));
        SetNumberRooms();
    }

    /**
     * Metodo para obtener una habitacion en total
     * @param index
     * @return
     */
    public Room getRoom( int index){
        return rooms.get(index);
    }
    /**
     * Metodo para obtener el total de habotaciones
     * @return
     */
    public int getSizeRooms(){
       return rooms.size();
    }

    /**
     * Metodo para mostrar la informacion de una habitacion en la posicion
     * @param index numero de la habitacion
     * @return mensaje completo
     */
    public String toStringRoom(int index){
        return "N°: "+rooms.get(index).getNumber()+" Calidad: "+rooms.get(index).getQuality()+"  Estado: "+(rooms.get(index).isOcupation()?"Ocupado":"No ocuapdo");
    }
}


