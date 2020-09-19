/*
 * Copyright (c) 12/9/2020.
 * created by Mateo Pinzon, Harrison Diaz y Juan Jose Ariza
 * All rights reserved
 */

package models;

public class CheckOut extends Event {

    /**
     * Metodo para asignar laas habitaciones
     * @param room para mirar cada habitacion
     */
    public void assingRoom(Room room){
        room.setOcupation(false);
    }
}
