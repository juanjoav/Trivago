/*
 * Copyright (c) 12/9/2020.
 * created by Mateo Pinzon, Harrison Diaz y Juan Jose Ariza
 * All rights reserved
 */

package models;

public class Room {
    private int number = 0;
    private Quality quality;
    private boolean ocupation;
    private double price;

    public Room(Quality quality) {
        this.number = 0;
        this.quality = quality;
        this.ocupation =  false;
        this.price = new Pay().getSeasonRoomPay(new Room(quality));
    }

    /**
     *Obtenemos el numero
     * @return
     */
    public int getNumber() {
        return number;
    }

    /**
     *Modificamos el numero
     * @param number
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     *Obtenemos la calidad
     * @return
     */
    public Quality getQuality() {
        return quality;
    }

    /**
     * modificamso la calidad
     * @param quality
     */
    public void setQuality(Quality quality) {
        this.quality = quality;
    }

    /**
     * Recuepra el valor ocupacion
     * @return false or true value
     */
    public boolean isOcupation() {
        return ocupation;
    }

    /**
     * Modifica la ocupacion
     * @param ocupation boolean value
     */
    public void setOcupation(boolean ocupation) {
        this.ocupation = ocupation;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
 