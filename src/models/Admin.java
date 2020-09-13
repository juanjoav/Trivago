/*
 * Copyright (c) 12/9/2020.
 * created by Mateo Pinzon, Harrison Diaz y Juan Jose Ariza
 * All rights reserved
 */

package models;

/**
 * modelado segun diagrama Admin, sin niguna logica
 */

public class Admin extends Person{

    String passaword;

    public Admin(String name, long id, String passaword) {
        super(name, id);
        this.passaword = passaword;
    }

    public void changeSeason(String season){

    }

    public Quality viewQuality(){
        Quality aux = Quality.ECONOMIC;
        return aux;
    }

    public void Status(User user){

    }

    /**
     * Revision de diagrama
     */
    public void reservation(){

    }
}
