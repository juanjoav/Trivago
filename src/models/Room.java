/*
 * Copyright (c) 12/9/2020.
 * created by Mateo Pinzon, Harrison Diaz y Juan Jose Ariza
 * All rights reserved
 */

package models;

public class Room {
    private int number;
    private Quality quality;
    private boolean ocupation;

    public Room( Quality quality) {
        this.number ++;
        this.quality = quality;
        this.ocupation =  false;
    }


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Quality getQuality() {
        return quality;
    }

    public void setQuality(Quality quality) {
        this.quality = quality;
    }

    public boolean isOcupation() {
        return ocupation;
    }

    public void setOcupation(boolean ocupation) {
        this.ocupation = ocupation;
    }
}
 