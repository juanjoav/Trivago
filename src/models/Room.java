/*
 * Copyright (c) 12/9/2020.
 * created by Mateo Pinzon, Harrison Diaz y Juan Jose Ariza
 * All rights reserved
 */

package models;


/**
 * Esta clase hace la implementacion de la habitacion
 * @Author Mateo Pinzon, Harrison Diaz y Juan Ariza
 * @Date 12/09/2020
 */
public class Room {

    private int number;
    private Quality quality;
    private boolean ocupation;

    /**
     * Metodo constructor parametrizado
     * @param quality calidad de una habitacion
     */
    public Room(Quality quality) {
        this.number = 0;
        this.quality = quality;
        this.ocupation =  false;
    }

    /**
     *Metodo para obtener el numero una habitacion
     * @return el numero de una habitacion
     */
    public int getNumber() {
        return number;
    }

    /**
     *Metodo que modifica el numero de la habitacion
     * @param number un numero entero
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     *Metodo para obtener la calidad de una habitacion
     * @return la calidad de una habitacion
     */
    public Quality getQuality() {
        return quality;
    }

    /**
     * Metodo para modificar la calidad de una habitacion
     * @param quality calidad de una habitacion
     */
    public void setQuality(Quality quality) {
        this.quality = quality;
    }

    /**
     * Metodo que nos dice si esta ocuapda o no una habitacion
     * @return verdadero si esta ocuapda, falso si no
     */
    public boolean isOcupation() {
        return ocupation;
    }

    /**
     * MEtodo que modifica la ocupacion de la habitacion
     * @param ocupation si esta o no ocupada una habitacion
     */
    public void setOcupation(boolean ocupation) {
        this.ocupation = ocupation;
    }


}
 