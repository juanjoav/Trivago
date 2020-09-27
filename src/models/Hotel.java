
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
    public List<Room> rooms;

    public User user;
    public Admin admin;

    /**
     * Metodo costructor por defeccto
     */
    public Hotel() {
        menus = new LinkedList();
        userTreeSet = new TreeSet<>();
        rooms = new ArrayList<Room>();
        for (int i = 0; i < 100; i++) {
            rooms.add(new Room(Quality.REGULAR));
        }
        //admin = new Admin();
        user = new User();
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
     * Recupera el room para hacer modificaciones
     * @param iterator numero de cual habitacion
     * @return
     */
    public Room getRoom(int iterator){
        return rooms.get(iterator);
    }

}


