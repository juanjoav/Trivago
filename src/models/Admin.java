/*
 * Copyright (c) 12/9/2020.
 * created by Mateo Pinzon, Harrison Diaz y Juan Jose Ariza
 * All rights reserved
 */

package models;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * modelado segun diagrama Admin, sin niguna logica
 */

public class Admin {

    private String userName;
    private String passaword;
    private Menu menu;
    private Hotel hotel;
    private AdminRoom adminRoom;

    public Admin(String userName, String passaword, Hotel hotel) {
        this.userName = userName;
        this.passaword = passaword;
        menu = new Menu();
        hotel = new Hotel();
        adminRoom = new AdminRoom();
    }

    public Admin() {

    }

    public void addMenu(Menu menu){
        hotel.menus.add(menu);
    }


    /**
     * agrega usuarios
     * @param user
     */
    public void addUser(User user){
        try{
            hotel.userTreeSet.add(user);
        }
        catch (NullPointerException exception){
            System.out.println("dato invalido");
        }
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

    public AdminRoom getAdminRoom(){
        return adminRoom;
    }


}
