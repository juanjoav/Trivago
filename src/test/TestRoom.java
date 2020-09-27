/*
 * Copyright (c) 26/9/2020.
 * created by Mateo Pinzon, Harrison Diaz y Juan Jose Ariza
 * All rights reserved
 */

package test;

import models.Admin;
import models.Quality;
import models.AdminRoom;
import models.Room;

public class TestRoom {
    public static void main(String[] args) {
        AdminRoom adminRoom = new AdminRoom();
        System.out.println("El tamaño de la matriz es 100: "+(adminRoom.getTotalRooms()==100?"Right":"Error"));
        System.out.println("El numero de habitaciones disponibles es de  100: "+(adminRoom.getAvailable()==100?"Right":"Error"));
        adminRoom.getRoom(15).setOcupation(true);
        adminRoom.getRoom(1).setOcupation(true);
        adminRoom.getRoom(55).setOcupation(true);
        System.out.println("El numero de habitaciones disponibles es de  97: "+(adminRoom.getAvailable()==97?"Right":"Error"));
        adminRoom.getRoom(46).setQuality(Quality.PREMIUM);
        adminRoom.getRoom(78).setQuality(Quality.PREMIUM);
        adminRoom.getRoom(9).setQuality(Quality.PREMIUM);
        adminRoom.getRoom(80).setQuality(Quality.ECONOMIC);
        adminRoom.getRoom(40).setQuality(Quality.PREMIUM);
        adminRoom.getRoom(33).setQuality(Quality.PREMIUM);
        adminRoom.getRoom(5).setQuality(Quality.ECONOMIC);
        adminRoom.getRoom(0).setQuality(Quality.ECONOMIC);
        adminRoom.add(new Room(Quality.PREMIUM));
        System.out.println("Numero de habitaciones regulares es de 92: "+(adminRoom.getQualityCounter(Quality.REGULAR)==92?"Right":"Error"));
        System.out.println("Numero de habitaciones Economico es de 3: "+(adminRoom.getQualityCounter(Quality.ECONOMIC)==3?"Right":"Error"));
        System.out.println("Numero de habitaciones Premium es de 6: "+(adminRoom.getQualityCounter(Quality.PREMIUM)==6?"Right":"Error"));
        System.out.println("El numero de habitaciones no disponibles es de  3: "+(adminRoom.getDisavailable()==3?"Right":"Error"));
    }
}
