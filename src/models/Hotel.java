
/*
 * Copyright (c) 12/9/2020.
 * created by Mateo Pinzon, Harrison Diaz y Juan Jose Ariza
 * All rights reserved
 */

package models;

import java.util.TreeSet;

public class Hotel {

    private TreeSet<User> userTreeSet;

    public Hotel() {
        userTreeSet = new TreeSet<User>();
    }

    public void addUser(User user){
        userTreeSet.add(user);
    }

    public void view(){
        System.out.println(userTreeSet);
    }

    public void viewUserInformation(){

    }
}
