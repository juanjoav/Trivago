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
    private String season;   //verificar

    public Admin(String userName, String passaword) {
        this.userName = userName;
        this.passaword = passaword;
    }

    public Admin() {

    }

    public void changeSeason(String season){
        switch (season.toLowerCase()){
            case "verano":
                this.season = season;
                break;
            case "invierno":
                this.season = season;
                break;
            case "otoño":
                this.season = season;
                break;
            case "primavera":
                this.season = season;
                break;
        }
    }

    public Quality viewQuality(){
        Quality aux = Quality.ECONOMIC;
        return aux;
    }

}
