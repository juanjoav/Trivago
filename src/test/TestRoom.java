/*
 * Copyright (c) 26/9/2020.
 * created by Mateo Pinzon, Harrison Diaz y Juan Jose Ariza
 * All rights reserved
 */

package test;

import models.Hotel;
import models.Quality;
import models.SetRoom;

public class TestRoom {
    public static void main(String[] args) {
        Hotel setRoom = new Hotel();
        System.out.println("El tamaño de la matriz es 100: "+(setRoom.getTotalRooms()==100?"Right":"Error"));
        System.out.println("El numero de habitaciones disponibles es de  100: "+(setRoom.getAvailable()==100?"Right":"Error"));
        setRoom.getRoom(15).setOcupation(true);
        setRoom.getRoom(1).setOcupation(true);
        setRoom.getRoom(55).setOcupation(true);
        System.out.println("El numero de habitaciones disponibles es de  97: "+(setRoom.getAvailable()==97?"Right":"Error"));
        setRoom.getRoom(46).setQuality(Quality.PREMIUM);
        setRoom.getRoom(78).setQuality(Quality.PREMIUM);
        setRoom.getRoom(9).setQuality(Quality.PREMIUM);
        setRoom.getRoom(80).setQuality(Quality.ECONOMIC);
        setRoom.getRoom(40).setQuality(Quality.PREMIUM);
        setRoom.getRoom(33).setQuality(Quality.PREMIUM);
        setRoom.getRoom(5).setQuality(Quality.ECONOMIC);
        setRoom.getRoom(0).setQuality(Quality.ECONOMIC);
        System.out.println("Numero de habitaciones regulares es de 92: "+(setRoom.getRegular()==92?"Right":"Error"));
        System.out.println("Numero de habitaciones Economico es de 3: "+(setRoom.getEconomic()==3?"Right":"Error"));
        System.out.println("Numero de habitaciones Premium es de 5: "+(setRoom.getPremium()==5?"Right":"Error"));
        System.out.println("El numero de habitaciones no disponibles es de  3: "+(setRoom.getDisavailable()==3?"Right":"Error"));
    }
}
