
/*
 * Copyright (c) 12/9/2020.
 * created by Mateo Pinzon, Harrison Diaz y Juan Jose Ariza
 * All rights reserved
 */

package models;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class Hotel {

    public LinkedList<Menu> menus;
    public TreeSet<User> userTreeSet;
    public List<Room> rooms;

    public Hotel() {
        menus = new LinkedList();
        userTreeSet = new TreeSet<>();
        rooms = new ArrayList<Room>();
        for (int i = 0; i < 100; i++) {
            rooms.add(new Room(i, Quality.REGULAR));
        }
    }

    /**
     * Metodo que retorna todos los menus disponibles
     * @return
     */
    public String[] viewMenus(){
        String[] aux = new String[menus.size()];
        for (int i = 0; i < aux.length; i++) {
            aux[i] = menus.get(i).showMenus();
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


