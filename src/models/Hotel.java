
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


    /**
     * Para decir que una habitacion esta fuera de serivicio
     * @param numb
     */
    public void outOfService(int numb){
        rooms.get(numb).setOcupation(true);
    }
}
