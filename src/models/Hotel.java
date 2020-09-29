
/*
 * Copyright (c) 12/9/2020.
 * created by Mateo Pinzon, Harrison Diaz y Juan Jose Ariza
 * All rights reserved
 */

package models;


import java.util.*;

/**
 * Esta clase hace la admnistacion e implementacion de todo lo que puede tener un hotel y lo que dependa de el
 * @Author Mateo Pinzon, Harrison Diaz y Juan Ariza
 * @Date 12/09/2020
 */

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
        SetNumberRooms();
    }

    /**
     * Metodo que nos permite agregar un nuevo usuario a la lista
     * @param user usuario a ser creado
     */
    public String addUser(User user){
        String message = "";
        if (!userTreeSet.add(user)){
            message = "Usuario ya registrado";
        }
        return message;
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
     * Metodo que  muestra el usuario consultado por ID
     * @param id para su busqueda en la lista de usuarios
     * @return el objeto de usuario encontrado
     */
    public User searchUser(long id){
        User aux = new User();
        for (User user: userTreeSet) {
            if (user.getId() == id){
                aux = user;
                return aux;
            }
        }
        return aux;
    }

    /**
     * Metodo que retorna todos los menus disponibles
     * @return los menus disponibles en el momento
     */
    public String[] viewMenus(){
        String[] aux = new String[menus.size()];
        for (int i = 0; i < aux.length; i++) {
            aux[i] = menus.get(i).formatMenus();
        }
        return aux;
    }

    /**
     * Metodo que coloca el numero de las habitaciones
     */
    private void SetNumberRooms(){
        int counter = 0;
        for (int i = 0; i < rooms.size(); i++) {
            rooms.get(i).setNumber(i);
            counter++;
        }
    }

    /**
     * Metod que pasa por quemado un numero determinado de habiotaciones o minimo de estas
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
     * @param room una habitacion
     */
    public void addRoom(Room room){
        rooms.add(room);
        SetNumberRooms();
    }

    /**
     * Metodo para aumentar el numero de habitaciones
     * @param quality calidad de una habitacion
     */
    public void addRoom(Quality quality){
        rooms.add(new Room(quality));
        SetNumberRooms();
    }

    /**
     * Metodo para obtener una habitacion en total
     * @param index el numero de las habitaciones
     * @return una habitacion en total
     */
    public Room getRoom( int index){
        return rooms.get(index);
    }

    /**
     * Metodo para obtener el total de habotaciones
     * @return El total de las habitaciones
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


